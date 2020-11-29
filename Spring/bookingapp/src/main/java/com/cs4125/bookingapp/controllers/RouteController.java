package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.model.RouteFactory;
import com.cs4125.bookingapp.model.entities.Route;
import com.cs4125.bookingapp.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class RouteController {
    @Autowired
    private RouteService routeService;
    @Autowired
    private RouteFactory routeFactory;

    @GetMapping(path="/getroute/{id}")
    @ResponseBody
    public String getRoute(@PathVariable int id) {
        String result = routeService.searchRoute(id);

        return result;
    }

    @GetMapping(path="/getroute")
    @ResponseBody
    public String getRoute(@RequestParam String startStation, @RequestParam String endStation, @RequestParam Timestamp dateTime) {
        String result = routeService.searchRoute(startStation, endStation, dateTime);

        return result;
    }

    @GetMapping(path="/getallroutes")
    @ResponseBody
    public String getAllRoutes(@RequestParam String startStation, @RequestParam String endStation, @RequestParam Timestamp dateTime) {
        List<String> result = routeService.searchAllRoutes(startStation, endStation, dateTime);

        return String.join("\n", result);
    }

    @PostMapping(path="/newroute")
    @ResponseBody
    public String addNewRoute (@RequestParam String startStation, @RequestParam String endStation, @RequestParam Timestamp dateTime, @RequestParam double price) {
        Route r = routeFactory.getRoute("NORMAL_ROUTE", startStation, endStation, dateTime, price);
        String result = routeService.addRoute(r);

        return result;
    }

    @PostMapping(path="/updateroute/{id}")
    @ResponseBody
    public String updateRoute (@PathVariable int id, @RequestParam String startStation, @RequestParam String endStation, @RequestParam Timestamp dateTime, @RequestParam double price) {
        Route r = routeFactory.getRoute("NORMAL_ROUTE", startStation, endStation, dateTime, price);
        r.setRouteId(id);
        String result = routeService.updateRoute(r);

        return result;
    }

    @PostMapping(path="/deleteroute/{id}")
    @ResponseBody
    public String deleteRoute (@PathVariable int id, @RequestParam String startStation, @RequestParam String endStation, @RequestParam Timestamp dateTime, @RequestParam double price) {
        Route r = routeFactory.getRoute("NORMAL_ROUTE", startStation, endStation, dateTime, price);
        r.setRouteId(id);
        String result = routeService.deleteRoute(r);

        return result;
    }
}
