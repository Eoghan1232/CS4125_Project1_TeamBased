package com.cs4125.bookingapp;

import com.cs4125.bookingapp.model.entities.*;
import com.cs4125.bookingapp.model.repositories.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
public class BasicController {
//
//    @Autowired
//    private UserRepository UserRepository;
//    @Autowired
//    private RouteRepository routeRepository;
//    @Autowired
//    private DiscountRepository DiscountRepository;
//    @Autowired
//    private BookingRepository BookingRepository;
//    @Autowired
//    private TransactionRepository TransactionRepository;
//
//
    @GetMapping(path="/")
    public String home(){
        return "Hey, you are not supposed to be here!";
    }
//
//
//    @GetMapping(path="/User")
//    public String user() {return "Hello this is User";}
//
//    @PostMapping(path="/add") // Map ONLY POST Requests
//    public @ResponseBody String addNewUser (@RequestParam String name
//            , @RequestParam String email) {
//
//        User n = new User();
//        n.setUsername(name);
//        n.setEmail(email);
//        n.setUsertype(1);
//        n.setPassword("Testing");
//        UserRepository.save(n);
//        return "Saved";
//    }
//
//    @PostMapping(path="/addRoute") // Map ONLY POST Requests
//    public @ResponseBody String addRoute (@RequestParam String name
//            , @RequestParam String email) {
//
//        Route r = new Route();
//        r.setEnd_station("c");
//        r.setStart_station("b");
//        r.setPrice(100);
//        r.setDate_time(Timestamp.valueOf(LocalDateTime.now()));
//        RouteRepository.save(r);
//        return "Saved";
//    }
//
//    @PostMapping(path="/addDiscount") // Map ONLY POST Requests
//    public @ResponseBody String addDiscount (@RequestParam String name
//            , @RequestParam String email) {
//
//        Discount d = new Discount();
//        d.setCode("BOO");
//        d.setDiscount_percent(20.0f);
//        d.setRoute_id("4");
//
//        DiscountRepository.save(d);
//        return "Saved";
//    }
//
//    @PostMapping(path="/addBooking") // Map ONLY POST Requests
//    public @ResponseBody String addBooking (@RequestParam String name
//            , @RequestParam String email) {
//
//        Booking b = new Booking();
//        b.setDateTime(Timestamp.valueOf(LocalDateTime.now()));
//        b.setQuantity(2);
//        b.setRouteId(1);
//        b.setTotalPrice(10);
//        b.setTransactionId(1);
//        b.setPassengerId(12);
//        BookingRepository.save(b);
//        return "Saved";
//    }
//
//    @PostMapping(path="/addTransactions") // Map ONLY POST Requests
//    public @ResponseBody String addTransaction (@RequestParam String name
//            , @RequestParam String email) {
//
//        TransactionRecord t = new TransactionRecord();
//        t.setAmount(12);
//        t.setDate_of_payment(Timestamp.valueOf(LocalDateTime.now()));
//        t.setStatus(0);
//
//        TransactionRepository.save(t);
//        return "Saved";
//    }
//
//    @GetMapping(path="/all")
//    public @ResponseBody Iterable<User> getAllUsers() {
//        // This returns a JSON or XML with the users
//        return UserRepository.findAll();
//    }
//
//    @GetMapping(path="/allRoute")
//    public @ResponseBody Iterable<Route> getRoutes() {
//        // This returns a JSON or XML with the users
//        return RouteRepository.findAll();
//    }
//
//    @GetMapping(path="/allDiscounts")
//    public @ResponseBody Iterable<Discount> getDiscounts() {
//        // This returns a JSON or XML with the users
//        return DiscountRepository.findAll();
//    }
//
//    @GetMapping(path="/allBookings")
//    public @ResponseBody Iterable<Booking> getBookings() {
//        // This returns a JSON or XML with the users
//        return BookingRepository.findAll();
//    }
//
//    @GetMapping(path="/allTransactions")
//    public @ResponseBody Iterable<TransactionRecord> getTransactions() {
//        // This returns a JSON or XML with the users
//        return TransactionRepository.findAll();
//    }
}
