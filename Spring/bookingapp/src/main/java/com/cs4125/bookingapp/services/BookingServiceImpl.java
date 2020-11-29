package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.Booking;
import com.cs4125.bookingapp.model.entities.Discount;
import com.cs4125.bookingapp.model.entities.Route;
import com.cs4125.bookingapp.model.entities.TransactionRecord;
import com.cs4125.bookingapp.model.repositories.BookingRepository;
import com.cs4125.bookingapp.model.repositories.DiscountRepository;
import com.cs4125.bookingapp.model.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private RouteRepository routeRepository;

    private TransactionContext transactionContext = new TransactionContext();

    /**
     * Searches booking by id
     * @param id id of the booking
     * @return SUCCESS: booking information if found the route, else FAILURE: error code
     */
    @Override
    public String searchBooking(int id) {
        Booking resBooking = bookingRepository.findById(id).orElse(null);
        if(resBooking == null) {
            return "FAILURE: 1";
        }

        return "SUCCESS: " + resBooking.toString();
    }

    /**
     * Searches all bookings by the passenger id
     * @param passengerId id of the passenger
     * @return List of strings containing information of the found bookings, if none found will return List with FAILURE: error code
     */
    @Override
    public List<String> searchAllBookings(int passengerId) {
        List<Booking> matchedBookings = bookingRepository.findAllByPassengerId(passengerId);
        List<String> result = new ArrayList<>();
        if(matchedBookings == null)
        {
            result.add("FAILURE: 1");
            return result;
        }

        if(matchedBookings.size() == 0)
        {
            result.add("FAILURE: 2");
            return result;
        }

        for(Booking b : matchedBookings) {
            result.add("SUCCESS: " + b.toString());
        }

        return result;
    }

    /**
     * Add a new booking
     * @param b booking to be added
     * @param discountCode discount code to check if price should be reduced
     * @return SUCCESS: booking information if adding was successful, else FAILURE: error code
     */
    @Override
    public String addBooking(Booking b, String discountCode) {
        // Make sure route id is valid, and update the date time on the booking
        Route desiredRoute = routeRepository.findById(b.getRouteId()).orElse(null);
        if(desiredRoute == null) {
            return "FAILURE: 1";
        }
        b.setDateTime(desiredRoute.getDateTime());

        // Check if discount code applies to given route
        Discount desiredDiscount = discountRepository.findByCode(discountCode);
        double discountAmount = 1.0;
        if(desiredDiscount != null) {
            String[] routeIDs = desiredDiscount.getRouteId().split("&&");
            for (String s : routeIDs) {
                if (s.equalsIgnoreCase(Integer.toString(b.getRouteId()))) {
                    discountAmount = discountAmount - (desiredDiscount.getDiscountPercent() / 100);
                    break;
                }
            }
        }
        double priceToPay = b.getQuantity() * (desiredRoute.getPrice() * discountAmount);

        // Create transaction record corresponding to this booking, start with initial state and move to the next
        TransactionRecord transactionRecord = new TransactionRecord(priceToPay, null);
        transactionContext.setTransactionRecord(transactionRecord);
        transactionContext.setTransactionRecordState(new TransactionRecordInitialState());
        transactionContext.nextState();

        // Final update to booking parameters
        b.setTotalPrice(priceToPay);
        b.setTransactionId(transactionContext.getTransactionRecord().getTransactionId());
        if(b.getTransactionId() == 0) {
            return "FAILURE: 2";
        }
        b = bookingRepository.save(b);

        return "SUCCESS: " + b.toString() + ", " + transactionContext.getCurrentState();
    }

    /**
     * Update a transaction related to a booking
     * @param b booking for which the transaction should be updated
     * @return SUCCESS: booking information if updating was successful, else FAILURE: error code
     */
    @Override
    public String updateTransaction(Booking b) {
        // no id supplied
        if (b.getBookingId() == 0) {
            return "FAILURE: 1";
        }

        Booking resBooking = bookingRepository.findById(b.getBookingId()).orElse(null);
        if (resBooking == null) {
            return "FAILURE: 2";
        }

        if(!transactionContext.setTransactionRecordByID(b.getTransactionId())) {
            return "FAILURE: 3";
        }

        transactionContext.nextState();

        return "SUCCESS: " + resBooking.toString() + ", " + transactionContext.getCurrentState();
    }

    /**
     * Cancel a booking
     * @param b booking to be cancelled
     * @return SUCCESS: amount refunded if cancelling was successful, else FAILURE: error code
     */
    @Override
    public String cancelBooking(Booking b) {
        // no id supplied
        if (b.getBookingId() == 0) {
            return "FAILURE: 1";
        }

        Booking resBooking = bookingRepository.findById(b.getBookingId()).orElse(null);
        if (resBooking == null) {
            return "FAILURE: 2";
        }

        if(!transactionContext.setTransactionRecordByID(b.getTransactionId())) {
            return "FAILURE: 3";
        }

        double amountReturned = transactionContext.getTransactionRecord().getAmount();
        long dayDifference = Long.MAX_VALUE;
        // If transaction was completed then calculate the amount returned based on when the planned travel date was
        if(transactionContext.getTransactionRecord().getStatus() == 2) {
            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDateTime travelDateTime = resBooking.getDateTime().toLocalDateTime();
            dayDifference = Duration.between(currentDateTime, travelDateTime).toDays();
            if (dayDifference <= 1) {
                amountReturned = 0;
            } else if (dayDifference <= 7) {
                amountReturned = amountReturned / 2;
            }
        }

        transactionContext.cancelTransaction(dayDifference);
        bookingRepository.deleteById(b.getBookingId());

        return "SUCCESS: " + amountReturned;
    }
}
