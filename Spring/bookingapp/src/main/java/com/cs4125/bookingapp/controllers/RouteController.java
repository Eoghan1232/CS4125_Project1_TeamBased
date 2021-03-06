package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.model.RouteFactory;
import com.cs4125.bookingapp.model.entities.Route;
import com.cs4125.bookingapp.services.LogFilter;
import com.cs4125.bookingapp.services.RouteService;
import com.cs4125.bookingapp.services.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class RouteController {
    @Autowired
    private RouteService routeService;
    @Autowired
    private FilterManager myManager;
    @Autowired
    private LogFilter logFilter;

    public void instantiateManager(){
        myManager.setFilter(logFilter);
        myManager.setTarget((Target) routeService);
    }
    /*
    @Autowired
    private RouteFactory routeFactory;
     */

    @GetMapping(path="/generateroutes")
    @ResponseBody
    public String generateAllRoutes(@PathVariable String startNodeName, @PathVariable String endNodeName)
    {
//        String result = routeService.findAllRoutes(startNodeName, endNodeName);
        instantiateManager();
        String request = "searchDiscountId," + startNodeName + "," + endNodeName;
        return myManager.filterRequest(request);
    }

    @GetMapping(path="/generatefilteredroutes")
    @ResponseBody
    public String generateFilteredRoutes(@PathVariable String startNodeName, @PathVariable String endNodeName, @PathVariable String filters)
    {
//        String result = routeService.findAllRoutesFiltered(startNodeName, endNodeName, filters);
        instantiateManager();
        String request = "searchDiscountId," + startNodeName + "," + endNodeName + "," + filters;
        return myManager.filterRequest(request);
    }

    /*
    // Will no longer need
    @GetMapping(path="/getroute/{id}")
    @ResponseBody
    public String getRoute(@PathVariable int id) {
        String result = routeService.searchRoute(id);

        return result;
    }

    // Will no longer need
    @GetMapping(path="/getroute")
    @ResponseBody
    public String getRoute(@RequestParam String startStation, @RequestParam String endStation, @RequestParam Timestamp dateTime) {
        String result = routeService.searchRoute(startStation, endStation, dateTime);

        return result;
    }

    // Will no longer need
    @GetMapping(path="/getallroutes")
    @ResponseBody
    public String getAllRoutes(@RequestParam String startStation, @RequestParam String endStation, @RequestParam Timestamp dateTime) {
        List<String> result = routeService.searchAllRoutes(startStation, endStation, dateTime);

        return String.join("\n", result);
    }

     */

    /*
    @PostMapping(path="/newroute")
    @ResponseBody
    public String addNewRoute (@RequestParam String startStation, @RequestParam String endStation, @RequestParam Timestamp dateTime, @RequestParam double price) {
        Route r = routeFactory.getRoute("NORMAL_ROUTE", startStation, endStation, dateTime, price);
        String result = routeService.addRoute(r);

        return result;
    }
     */

    /*
    @PostMapping(path="/updateroute/{id}")
    @ResponseBody
    public String updateRoute (@PathVariable int id, @RequestParam String startStation, @RequestParam String endStation, @RequestParam Timestamp dateTime, @RequestParam double price) {
        Route r = routeFactory.getRoute("NORMAL_ROUTE", startStation, endStation, dateTime, price);
        r.setRouteId(id);
        String result = routeService.updateRoute(r);

        return result;
    }

     */

    /*
    @PostMapping(path="/deleteroute/{id}")
    @ResponseBody
    public String deleteRoute (@PathVariable int id, @RequestParam String startStation, @RequestParam String endStation, @RequestParam Timestamp dateTime, @RequestParam double price) {
        Route r = routeFactory.getRoute("NORMAL_ROUTE", startStation, endStation, dateTime, price);
        r.setRouteId(id);
        String result = routeService.deleteRoute(r);

        return result;
    }
     */
}