package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.model.IRouteFactory;
import com.cs4125.bookingapp.model.RouteFactory;
import com.cs4125.bookingapp.model.entities.Route;
import com.cs4125.bookingapp.model.entities.User;
import com.cs4125.bookingapp.services.IRouteService;
import com.cs4125.bookingapp.services.RouteService;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class RouteController {
    private IRouteService routeService = new RouteService();
    private IRouteFactory routeFactory = new RouteFactory();

    @GetMapping("/getroute/{id}")
    @ResponseBody
    public String getRoute(@PathVariable int id) {
        String result = routeService.searchRoute(id);

        return result;
    }

    @GetMapping("/getroute")
    @ResponseBody
    public String getRoute(@RequestParam String start_station, @RequestParam String end_station, @RequestParam Timestamp date_time) {
        String result = routeService.searchRoute(start_station, end_station, date_time);

        return result;
    }

    @GetMapping("/getallroutes")
    @ResponseBody
    public String getAllRoutes(@RequestParam String start_station, @RequestParam String end_station, @RequestParam Timestamp date_time) {
        List<String> result = routeService.searchAllRoutes(start_station, end_station, date_time);

        return String.join("\n", result);
    }

    @PostMapping(path="/newroute")
    @ResponseBody
    public String addNewRoute (@RequestParam float price, @RequestParam String start_station, @RequestParam String end_station, @RequestParam Timestamp date_time) {
        Route r = routeFactory.getRoute("NORMAL_ROUTE", price, start_station, end_station, date_time);
        String result = routeService.addRoute(r);

        return result;
    }

    @PostMapping(path="/updateroute/{id}")
    @ResponseBody
    public String updateRoute (@PathVariable int id, @RequestParam float price, @RequestParam String start_station, @RequestParam String end_station, @RequestParam Timestamp date_time) {
        Route r = routeFactory.getRoute("NORMAL_ROUTE", price, start_station, end_station, date_time);
        r.setRoute_id(id);
        String result = routeService.updateRoute(r);

        return result;
    }

    @PostMapping(path="/deleteroute/{id}")
    @ResponseBody
    public String deleteRoute (@PathVariable int id, @RequestParam float price, @RequestParam String start_station, @RequestParam String end_station, @RequestParam Timestamp date_time) {
        Route r = routeFactory.getRoute("NORMAL_ROUTE", price, start_station, end_station, date_time);
        r.setRoute_id(id);
        String result = routeService.deleteRoute(r);

        return result;
    }
}
