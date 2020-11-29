package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.model.entities.Booking;
import com.cs4125.bookingapp.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping(path="/getbooking/{id}")
    @ResponseBody
    public String getBooking(@PathVariable int id) {
        String result = bookingService.searchBooking(id);

        return result;
    }

    @GetMapping(path="/getallbookings/{passengerId}")
    @ResponseBody
    public String getAllBookings(@PathVariable int passengerId) {
        List<String> result = bookingService.searchAllBookings(passengerId);

        return String.join("\n", result);
    }

    @PostMapping(path="/newbooking")
    @ResponseBody
    public String addNewBooking (@RequestParam int routeId, @RequestParam int userId, @RequestParam int quantity, @RequestParam String discountCode) {
        Booking b = new Booking(routeId, userId, quantity, null, -1, -1);
        String result = bookingService.addBooking(b, discountCode);

        return result;
    }

    @PostMapping(path="/paybooking/{id}")
    @ResponseBody
    public String payForBooking (@PathVariable int id) {
        Booking b = new Booking();
        b.setBookingId(id);
        String result = bookingService.updateTransaction(b);

        return result;
    }

    @PostMapping(path="/cancelbooking/{id}")
    @ResponseBody
    public String cancelBooking (@PathVariable int id) {
        Booking b = new Booking();
        b.setBookingId(id);
        String result = bookingService.cancelBooking(b);

        return result;
    }
}
