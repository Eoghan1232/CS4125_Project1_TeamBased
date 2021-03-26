package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.services.BookingService;
import com.cs4125.bookingapp.services.interceptor.FilterManager;
import com.cs4125.bookingapp.services.interceptor.LogFilter;
import com.cs4125.bookingapp.services.interceptor.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    private final BookingService bookingService;
    private final FilterManager myManager;
    private final LogFilter logFilter;

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

    // TODO: will need to change if implementing route planing
    @PostMapping(path="/newbooking")
    @ResponseBody
    public String addNewBooking (@RequestParam String startNode, @RequestParam String endNode, @RequestParam String connectionPath,
                                 @RequestParam int userId, @RequestParam int quantity, @RequestParam String discountCode) {
//        Booking b = new Booking(routeId, userId, quantity, null, -1, -1);
//        String result = bookingService.addBooking(b, discountCode);
        instantiateManager();
        //String request = "addBooking," + routeId + "," + userId + "," + quantity + "," + discountCode;
        String request = "addBooking," + startNode + "," + endNode + "," + connectionPath + "," + userId + "," + quantity + "," + discountCode;
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