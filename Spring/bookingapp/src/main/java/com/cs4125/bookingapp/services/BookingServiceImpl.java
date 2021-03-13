package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.Booking;
import com.cs4125.bookingapp.model.entities.Route;
import com.cs4125.bookingapp.model.entities.TransactionRecord;
import com.cs4125.bookingapp.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService, Target {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    private TransactionContext transactionContext = new TransactionContext();

    @Override
    public String execute(String request) {

        String result = "";
        String str[] = request.split(",");
        Booking b;

        switch(str[0]) {
            case("searchBooking"):
                result = searchBooking(Integer.parseInt(str[1]));
                break;
            case("searchAllBookings"):
                result = searchAllBookings(Integer.parseInt(str[1])).toString();
                break;
            case("addBooking"):
                Route r = new Route(str[1], str[2], str[3]);
                b = new Booking(-1, Integer.parseInt(str[4]), Integer.parseInt(str[5]), null, -1, -1);
                result = addBooking(r, b, str[6]);
                break;
            case("updateTransaction"):
                b = new Booking();
                b.setBookingId(Integer.parseInt(str[1]));
                result = updateTransaction(b);
                break;
            case("cancelBooking"):
                b = new Booking();
                b.setBookingId(Integer.parseInt(str[1]));
                result = cancelBooking(b);
                break;
            default:
                return "FAILURE: 1";
        }
        return result;
    }

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
     * @param r route that is being booked
     * @param b booking to be added
     * @param discountCode discount code to check if price should be reduced
     * @return SUCCESS: booking information if adding was successful, else FAILURE: error code
     */
    @Override
    public String addBooking(Route r, Booking b, String discountCode) {
        // Make sure route id is valid, and update the date time on the booking
//        Route desiredRoute = routeRepository.findById(b.getRouteId()).orElse(null);
//        if(desiredRoute == null) {
//            return "FAILURE: 1";
//        }
//
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        LocalDateTime travelDateTime = desiredRoute.getDateTime().toLocalDateTime();
//        long dayDifference = Duration.between(currentDateTime, travelDateTime).toDays();
//        if(dayDifference < 0) {
//            return "FAILURE: 2";
//        }
//
//        b.setDateTime(desiredRoute.getDateTime());
//
//        // Check if discount code applies to given route
//        Discount desiredDiscount = discountRepository.findByCode(discountCode);
//        double discountAmount = 1.0;
//        if(desiredDiscount != null) {
//            String[] routeIDs = desiredDiscount.getRouteId().split("&&");
//            for (String s : routeIDs) {
//                if (s.equalsIgnoreCase(Integer.toString(b.getRouteId()))) {
//                    discountAmount = discountAmount - (desiredDiscount.getDiscountPercent() / 100);
//                    break;
//                }
//            }
//        }
//        double priceToPay = b.getQuantity() * (desiredRoute.getPrice() * discountAmount);
//
//        // Create transaction record corresponding to this booking, start with initial state and move to the next
//        TransactionRecord transactionRecord = new TransactionRecord(priceToPay, null);
//        transactionContext.setTransactionRecord(transactionRecord);
//        transactionContext.setTransactionRecordState(new TransactionRecordInitialState());
//        transactionContext.nextState();
//        transactionRepository.save(transactionContext.getTransactionRecord());
//
//        // Final update to booking parameters
//        b.setTotalPrice(priceToPay);
//        b.setTransactionId(transactionContext.getTransactionRecord().getTransactionId());
//        if(b.getTransactionId() == 0) {
//            return "FAILURE: 3";
//        }
//        b = bookingRepository.save(b);
//
//        return "SUCCESS: " + b.toString() + ", " + transactionContext.getCurrentState();
        return "FAILURE: 1";
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

        TransactionRecord transactionRecord = transactionRepository.findById(resBooking.getTransactionId()).orElse(null);
        if(transactionRecord == null) {
            return "FAILURE: 3";
        }

        transactionContext.setTransactionRecord(transactionRecord);
        transactionContext.nextState();
        transactionRepository.save(transactionContext.getTransactionRecord());

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

        TransactionRecord transactionRecord = transactionRepository.findById(resBooking.getTransactionId()).orElse(null);
        if(transactionRecord == null) {
            return "FAILURE: 3";
        }
        transactionContext.setTransactionRecord(transactionRecord);

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
        transactionRepository.save(transactionContext.getTransactionRecord());
        bookingRepository.deleteById(b.getBookingId());

        return "SUCCESS: " + amountReturned;
    }

}
