package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.services.interceptor.FilterManager;
import com.cs4125.bookingapp.services.interceptor.LogFilter;
import com.cs4125.bookingapp.services.RouteService;
import com.cs4125.bookingapp.services.interceptor.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RouteController {

    private final RouteService routeService;
    private final FilterManager myManager;
    private final LogFilter logFilter;

    @Autowired
    public RouteController(RouteService routeService, FilterManager myManager, LogFilter logFilter) {
        this.routeService = routeService;
        this.myManager = myManager;
        this.logFilter = logFilter;
    }

    public void instantiateManager(){
        myManager.setFilter(logFilter);
        myManager.setTarget((Target) routeService);
    }

    @GetMapping(path="/generateroutes")
    @ResponseBody
    public String generateAllRoutes(@RequestParam String startNodeName, @RequestParam String endNodeName, @RequestParam String dateTime)
    {
//        String result = routeService.findAllRoutes(startNodeName, endNodeName);
        instantiateManager();
        String request = "generateAllRoutes," + startNodeName + "," + endNodeName + "," + dateTime;
        return myManager.filterRequest(request);
    }

    @GetMapping(path="/generatefilteredroutes")
    @ResponseBody
    public String generateFilteredRoutes(@RequestParam String startNodeName, @RequestParam String endNodeName, @RequestParam String filters, @RequestParam String dateTime)
    {
//        String result = routeService.findAllRoutesFiltered(startNodeName, endNodeName, filters);
        instantiateManager();
        String request = "generateFilteredRoutes," + startNodeName + "," + endNodeName + "," + filters + "," + dateTime;
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