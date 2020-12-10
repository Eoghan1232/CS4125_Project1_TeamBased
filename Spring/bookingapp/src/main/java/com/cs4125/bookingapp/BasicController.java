package com.cs4125.bookingapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @GetMapping(path="/")
    public String home(){return "HomePage";}
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private UserFactory userFactory;
//    @Autowired
//    private RouteService routeService;
//    @Autowired
//    private DiscountService discountService;
//    @Autowired
//    private RouteFactory routeFactory;
//
//    @GetMapping(path="/fillData")
//    public String home(){
//        User u = userFactory.getUser("NORMAL_USER", "Dummy", "testing", "dummyEmail@gmail.com");
//        String result = userService.register(u);
//        userService.register(u);
//         u = userFactory.getUser("NORMAL_USER", "Test", "testing", "test@gmail.com");
//        userService.register(u);
//         u = userFactory.getUser("NORMAL_USER", "Coffee", "coffee", "IDrinkCoffee@gmail.com");
//        userService.register(u);
//        Timestamp dateTime = Timestamp.valueOf("2020-12-1 09:00:00");
//        Route r = routeFactory.getRoute("NORMAL_ROUTE","ED1","ED2",dateTime,20);
//        result = routeService.addRoute(r);
//        r = routeFactory.getRoute("NORMAL_ROUTE", "ED2", "ED3", dateTime, 10);
//        result = routeService.addRoute(r);
//        dateTime = Timestamp.valueOf("2021-07-1 11:00:00");
//        r = routeFactory.getRoute("NORMAL_ROUTE", "ED3", "ED4", dateTime, 15);
//        result = routeService.addRoute(r);
//        ArrayList<String> temp = new ArrayList<String>();
//        temp.add("1");
//        Discount d = new Discount("EDRK", String.join("&&", temp), 12);
//        result = discountService.addDiscount(d);
//        temp.add("2");
//        d = new Discount("EDFF", String.join("&&", temp), 10);
//        result = discountService.addDiscount(d);
//        temp.add("3");
//        d = new Discount("DFRR", String.join("&&", temp), 15);
//        result = discountService.addDiscount(d);
//
//        return "Success";
//    }
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
