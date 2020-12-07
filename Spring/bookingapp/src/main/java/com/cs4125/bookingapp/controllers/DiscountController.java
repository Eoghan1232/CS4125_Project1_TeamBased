package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.model.entities.Discount;
import com.cs4125.bookingapp.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @GetMapping(path="/getdiscount/{id}")
    @ResponseBody
    public String getDiscount(@PathVariable int id) {
        String result = discountService.searchDiscount(id);

        return result;
    }

    @GetMapping(path="/getdiscount")
    @ResponseBody
    public String getDiscount(@RequestParam String code) {
        String result = discountService.searchDiscount(code);

        return result;
    }

    @GetMapping(path="/getalldiscounts")
    @ResponseBody
    public String getAllDiscount() {
        List<String> result = discountService.searchAllDiscounts();

        return String.join("\n", result);
    }

    @PostMapping(path="/newdiscount")
    @ResponseBody
    public String addNewDiscount (@RequestParam String code, @RequestParam List<String> routeIds, @RequestParam double discountPercent) {
        Discount d = new Discount(code, String.join("&&", routeIds), discountPercent);
        String result = discountService.addDiscount(d);

        return result;
    }

    @PostMapping(path="/updatediscount/{id}")
    @ResponseBody
    public String updateRoute (@PathVariable int id, @RequestParam String code, @RequestParam List<String> routeIds, @RequestParam double discountPercent) {
        Discount d = new Discount(code, String.join("&&", routeIds), discountPercent);
        d.setDiscountId(id);
        String result = discountService.updateRoute(d);

        return result;
    }

    @PostMapping(path="/deletediscount/{id}")
    @ResponseBody
    public String deleteRoute (@PathVariable int id, @RequestParam String code, @RequestParam List<String> routeIds, @RequestParam double discountPercent) {
        Discount d = new Discount(code, String.join("&&", routeIds), discountPercent);
        d.setDiscountId(id);
        String result = discountService.deleteRoute(d);

        return result;
    }
}