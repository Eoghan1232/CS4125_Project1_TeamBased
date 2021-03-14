package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.services.interceptor.FilterManager;
import com.cs4125.bookingapp.services.interceptor.LogFilter;
import com.cs4125.bookingapp.services.RouteService;
import com.cs4125.bookingapp.services.interceptor.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(path="/generateroutes/1")
    @ResponseBody
    public String generateAllRoutes()
    {
//        String result = routeService.findAllRoutes(startNodeName, endNodeName);
        instantiateManager();
        String request = "generateAllRoutes," + "N1" + "," + "N3";
        return myManager.filterRequest(request);
    }


    @GetMapping(path="/generateroutes")
    @ResponseBody
    public String generateAllRoutes(@PathVariable String startNodeName, @PathVariable String endNodeName)
    {
//        String result = routeService.findAllRoutes(startNodeName, endNodeName);
        instantiateManager();
        String request = "generateAllRoutes," + startNodeName + "," + endNodeName;
        return myManager.filterRequest(request);
    }

    @GetMapping(path="/generatefilteredroutes")
    @ResponseBody
    public String generateFilteredRoutes(@PathVariable String startNodeName, @PathVariable String endNodeName, @PathVariable String filters)
    {
//        String result = routeService.findAllRoutesFiltered(startNodeName, endNodeName, filters);
        instantiateManager();
        String request = "generateFilteredRoutes," + startNodeName + "," + endNodeName + "," + filters;
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