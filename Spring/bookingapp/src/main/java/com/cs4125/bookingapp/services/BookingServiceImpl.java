package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.Booking;
import com.cs4125.bookingapp.model.entities.Discount;
import com.cs4125.bookingapp.model.entities.Route;
import com.cs4125.bookingapp.model.entities.TransactionRecord;
import com.cs4125.bookingapp.model.repositories.*;
import com.cs4125.bookingapp.services.commandDiscount.ApplyAllDiscounts;
import com.cs4125.bookingapp.services.commandDiscount.ApplyDiscount;
import com.cs4125.bookingapp.services.commandDiscount.DiscountContext;
import com.cs4125.bookingapp.services.commandDiscount.DiscountInvoker;
import com.cs4125.bookingapp.services.interceptor.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService, Target {

    private final BookingRepository bookingRepository;
    private final DiscountRepository discountRepository;
    private final RouteRepository routeRepository;
    private final TransactionRepository transactionRepository;

    private TransactionContext transactionContext = new TransactionContext();

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, DiscountRepository discountRepository, RouteRepository routeRepository, TransactionRepository transactionRepository) {
        this.bookingRepository = bookingRepository;
        this.discountRepository = discountRepository;
        this.routeRepository = routeRepository;
        this.transactionRepository = transactionRepository;
    }

    //Document this please.
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
                Instant dateTime = Instant.parse(str[5]);
                b = new Booking(Integer.parseInt(str[6]), -1, Integer.parseInt(str[7]), Timestamp.from(dateTime), -1, -1);
                b.setTotalPrice(b.getQuantity() * Double.parseDouble(str[4]));
                result = addBooking(r, b, str[8]);
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
    public String addBooking(Route r, Booking b, String discountCode)
    {
        // First make sure to add the route to the DB
        r = routeRepository.save(r);
        b.setRouteId(r.getRouteId());

        // Check for discounts if total price is above 0
        if(b.getTotalPrice() > 0)
        {
            Discount desiredDiscount;
            DiscountContext discountContext;
            DiscountInvoker discountInvoker;

            if(discountCode.contains("&"))
            {
                List<DiscountContext> allDiscounts = new ArrayList<>();
                String[] discountCodes = discountCode.split("&");
                for(String s : discountCodes)
                {
                    desiredDiscount = discountRepository.findByCode(s);
                    discountContext = new DiscountContext(desiredDiscount);
                    allDiscounts.add(discountContext);
                    // limit to 5 discounts
                    if(allDiscounts.size() >= 5)
                        break;
                }
                ApplyAllDiscounts applyMultipleDiscounts = new ApplyAllDiscounts(allDiscounts);
                discountInvoker = new DiscountInvoker(applyMultipleDiscounts);
            }
            else
            {
                desiredDiscount = discountRepository.findByCode(discountCode);
                discountContext = new DiscountContext(desiredDiscount);
                ApplyDiscount applySingleDiscount = new ApplyDiscount(discountContext);
                discountInvoker = new DiscountInvoker(applySingleDiscount);
            }

            double discountAmount = discountInvoker.execute(1.0);

            // limit to 50% off
            if(discountAmount < 0.5)
                discountAmount = 0.5;

            b.setTotalPrice(b.getTotalPrice() * discountAmount);
        }

        // Create transaction record corresponding to this booking, start with initial state and move to the next
        TransactionRecord transactionRecord = new TransactionRecord(b.getTotalPrice(), null);
        transactionContext.setTransactionRecord(transactionRecord);
        transactionContext.setTransactionRecordState(new TransactionRecordInitialState());
        transactionContext.nextState();
        transactionRepository.save(transactionContext.getTransactionRecord());

        // Final update to booking parameters
        b.setTransactionId(transactionContext.getTransactionRecord().getTransactionId());
        if(b.getTransactionId() == 0) {
            return "FAILURE: 3";
        }

        b = bookingRepository.save(b);


        return "SUCCESS: " + b.toString();
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
