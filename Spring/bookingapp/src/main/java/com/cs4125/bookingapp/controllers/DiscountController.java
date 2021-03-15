package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.services.DiscountService;
import com.cs4125.bookingapp.services.interceptor.FilterManager;
import com.cs4125.bookingapp.services.interceptor.LogFilter;
import com.cs4125.bookingapp.services.interceptor.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscountController {

    private final DiscountService discountService;
    private final FilterManager myManager;
    private final LogFilter logFilter;

    @Autowired
    public DiscountController(DiscountService discountService, FilterManager myManager, LogFilter logFilter) {
        this.discountService = discountService;
        this.myManager = myManager;
        this.logFilter = logFilter;
    }

    public void instantiateManager(){
        myManager.setFilter(logFilter);
        myManager.setTarget((Target) discountService);
    }

    @GetMapping(path="/getdiscount/{id}")
    @ResponseBody
    public String getDiscount(@PathVariable int id) {
//        String result = discountService.searchDiscount(id);
        instantiateManager();
        String request = "searchDiscountId," + id;
        return myManager.filterRequest(request);
    }

    @GetMapping(path="/getdiscount")
    @ResponseBody
    public String getDiscount(@RequestParam String code) {
//        String result = discountService.searchDiscount(code);
        instantiateManager();
        String request = "searchDiscountCode," + code;
        return myManager.filterRequest(request);
    }

    @GetMapping(path="/getalldiscounts")
    @ResponseBody
    public String getAllDiscount() {
        instantiateManager();
        String request = "searchDiscountId,";
        return myManager.filterRequest(request);
    }

    @PostMapping(path="/newdiscount")
    @ResponseBody
    public String addNewDiscount (@RequestParam String code, @RequestParam List<String> routeIds, @RequestParam double discountPercent) {
//        Discount d = new Discount(code, String.join("&&", routeIds), discountPercent);
//        String result = discountService.addDiscount(d);
        instantiateManager();
        String request = "addBooking," + code + "," + String.join("&&", routeIds) + "," + discountPercent;
        return myManager.filterRequest(request);
    }

    @PostMapping(path="/updatediscount/{id}")
    @ResponseBody
    public String updateDiscount (@PathVariable int id, @RequestParam String code, @RequestParam List<String> routeIds, @RequestParam double discountPercent) {
//        Discount d = new Discount(code, String.join("&&", routeIds), discountPercent);
//        d.setDiscountId(id);
//        String result = discountService.updateDiscount(d);
        String request = "updateDiscount," + id + "," + code + "," + String.join("&&", routeIds) + "," + discountPercent;;
        return myManager.filterRequest(request);
    }

    @PostMapping(path="/deletediscount/{id}")
    @ResponseBody
    public String deleteDiscount (@PathVariable int id, @RequestParam String code, @RequestParam List<String> routeIds, @RequestParam double discountPercent) {
//        Discount d = new Discount(code, String.join("&&", routeIds), discountPercent);
//        d.setDiscountId(id);
//        String result = discountService.deleteDiscount(d);
        String request = "updateDiscount," + id + "," + code + "," + String.join("&&", routeIds) + "," + discountPercent;;
        return myManager.filterRequest(request);
    }
}