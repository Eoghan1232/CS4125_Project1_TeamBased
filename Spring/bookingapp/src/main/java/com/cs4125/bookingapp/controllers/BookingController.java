package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.services.BookingService;
import com.cs4125.bookingapp.services.interceptor.FilterManager;
import com.cs4125.bookingapp.services.interceptor.LogFilter;
import com.cs4125.bookingapp.services.interceptor.Target;
import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Charge;
import com.stripe.model.Event;
import com.stripe.model.PaymentIntent;
import com.stripe.net.Webhook;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BookingController {

    private final BookingService bookingService;
    private final FilterManager myManager;
    private final LogFilter logFilter;

    private final String stripePublicKey = "pk_test_51IX7WzA4GQu91tA9ygW9sAl0Q42Y0pQYRySwRCSfylSVx9EiL3n691M0ayb6n45E9B7dx8DjfKn1iAwQSrfE24Dn00TDsAbjXU";
    private final String stripeSecretKey = "sk_test_51IX7WzA4GQu91tA9L6s5Nssb1MC2sVodWphIYYApH0ZwzsokQFlLFm44LeDfVvuHlmfdbs8rUpxgxCzMgc98d5ky00v1YjwyaH";
    private final String webhook = "whsec_6NH5GgR2e4hxyqgVWpElD83upKfhfSi2";

    @Autowired
    public BookingController(BookingService bookingService, FilterManager myManager, LogFilter logFilter) {
        this.bookingService = bookingService;
        this.myManager = myManager;
        this.logFilter = logFilter;
    }

    public void instantiateManager(){
        myManager.setFilter(logFilter);
        myManager.setTarget((Target) bookingService);
    }

    @GetMapping(path="/getbooking/{id}")
    @ResponseBody
    public String getBooking(@PathVariable int id) {
        //1 it calls the interceptor and passes this
        //2 it goes from interceptor, logs it and passes it to the execute in the Target
        instantiateManager();
        String request = "searchBooking," + id;
        return myManager.filterRequest(request);
    }

    @GetMapping(path="/getallbookings/{passengerId}")
    @ResponseBody
    public String getAllBookings(@PathVariable int passengerId) {
//        List<String> result = bookingService.searchAllBookings(passengerId);
        instantiateManager();
        String request = "searchAllBookings," + passengerId;
        return myManager.filterRequest(request);
    }

    @PostMapping(path="/newbooking")
    @ResponseBody
    public String addNewBooking (@RequestParam String startNode, @RequestParam String endNode,
                                 @RequestParam String connectionPath, @RequestParam double price, @RequestParam String dateTime,
                                 @RequestParam int userId, @RequestParam int quantity, @RequestParam String discountCode) {
//        Booking b = new Booking(routeId, userId, quantity, null, -1, -1);
//        String result = bookingService.addBooking(b, discountCode);
        instantiateManager();
        //String request = "addBooking," + routeId + "," + userId + "," + quantity + "," + discountCode;
        String request = "addBooking," + startNode + "," + endNode + "," + connectionPath + "," + price + "," + dateTime + "," + userId + "," + quantity + "," + discountCode;
        return myManager.filterRequest(request);
    }

    @PostMapping(path="/paybooking/{id}")
    @ResponseBody
    public String payForBooking (@PathVariable int id) {
//        Booking b = new Booking();
//        b.setBookingId(id);
//        String result = bookingService.updateTransaction(b);
        String request = "updateTransaction," + id;
        return myManager.filterRequest(request);
    }

    @PostMapping(path="/cancelbooking/{id}")
    @ResponseBody
    public String cancelBooking (@PathVariable int id) {
//        Booking b = new Booking();
//        b.setBookingId(id);
//        String result = bookingService.cancelBooking(b);
        String request = "cancelBooking," + id;
        return myManager.filterRequest(request);
    }

}