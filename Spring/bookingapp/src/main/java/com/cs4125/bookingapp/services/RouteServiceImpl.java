package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.controllers.Target;
import com.cs4125.bookingapp.model.entities.Discount;
import com.cs4125.bookingapp.model.entities.Route;
import com.cs4125.bookingapp.model.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class RouteServiceImpl implements RouteService, Target {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public String execute(String request) {

        String result = "";
        String str[] = request.split(",");

        switch(str[0]) {
            case("findAllRoutes"):
                result = findAllRoutes(str[1], str[2]);
                break;
            case("findAllRoutesFiltered"):
                result = findAllRoutesFiltered(str[1], str[2], str[3]);
                break;
            default:
                return "FAILURE: 1";
        }
        return result;
    }

    @Override
    public String findAllRoutes(String startNodeName, String endNodeName) {
        //TODO: Implement once we implement strategy pattern to find routes
        return null;
    }

    @Override
    public String findAllRoutesFiltered(String startNodeName, String endNodeName, String filters) {
        //TODO: Implement once we implement strategy and filter patterns to find routes
        return null;
    }


    /*
     * Searches route by id
     * @param id id of the route
     * @return SUCCESS: route information if found the route, else FAILURE: error code
     *//*
    @Override
    public String searchRoute(int id) {
        Route resRoute = routeRepository.findById(id).orElse(null);
        if(resRoute == null) {
            return "FAILURE: 1";
        }

        return "SUCCESS: " + resRoute.toString();
    }

    *//*
     * Searches route by stations and datetime
     * @param startStation name of start station
     * @param endStation name of end station
     * @param dateTime date and time of the route
     * @return SUCCESS: route information if found the route, else FAILURE: error code
     *//*
    @Override
    public String searchRoute(String startStation, String endStation, Timestamp dateTime) {
        Route resRoute = routeRepository.findByStartStationAndEndStationAndDateTime(startStation, endStation, dateTime);
        if(resRoute == null) {
            return "FAILURE: 1";
        }

        return "SUCCESS: " + resRoute.toString();
    }

    *//*
     * Searches all routes by any combination of the given parameters
     * @param startStation name of start station
     * @param endStation name of end station
     * @param dateTime date and time of the route
     * @return List of strings containing information of the found routes, if none found will return List with FAILURE: error code
     *//*
    @Override
    public List<String> searchAllRoutes(String startStation, String endStation, Timestamp dateTime) {
        List<Route> matchedRoutes = routeRepository.findAllByStartStationOrEndStationOrDateTime(startStation, endStation, dateTime);
        List<String> result = new ArrayList<>();
        if(matchedRoutes == null)
        {
            result.add("FAILURE: 1");
            return result;
        }

        if(matchedRoutes.size() == 0)
        {
            result.add("FAILURE: 2");
            return result;
        }

        for(Route r : matchedRoutes) {
            result.add("SUCCESS: " + r.toString());
        }

        return result;
    }

    *//*
     * Add a new route
     * @param r route to be added
     * @return SUCCESS: routeid if adding was successful, else FAILURE: error code
     *//*
    @Override
    public String addRoute(Route r) {
        Route routeCheck = routeRepository.findByStartStationAndEndStationAndDateTime(r.getStartStation(), r.getEndStation(), r.getDateTime());
        if (routeCheck != null) {
            return "FAILURE: 1";
        }
        r = routeRepository.save(r);

        return "SUCCESS: " + r.getRouteId();
    }

    *//*
     * Update a route
     * @param r route with updated variables
     * @return SUCCESS: routeid if update was successful, else FAILURE: error code
     *//*
    @Override
    public String updateRoute(Route r) {
        // no id supplied
        if (r.getRouteId() == 0) {
            return "FAILURE: 1";
        }

        if (!routeRepository.existsById(r.getRouteId())) {
            return "FAILURE: 2";
        }
        // if there is route with given id already save() will update the entry
        r = routeRepository.save(r);

        return "SUCCESS: " + r.getRouteId();
    }

    *//*
     * Delete a route
     * @param r route to be deleted
     * @return SUCCESS: 0 if deletion was successful, else FAILURE: error code
     *//*
    @Override
    public String deleteRoute(Route r) {
        // no id supplied
        if (r.getRouteId() == 0) {
            return "FAILURE: 1";
        }

        if (!routeRepository.existsById(r.getRouteId())) {
            return "FAILURE: 2";
        }

        // Delete route and check if deletion was successful
        routeRepository.deleteById(r.getRouteId());
        if (routeRepository.existsById(r.getRouteId())) {
            return "FAILURE: 3";
        }

        return "SUCCESS: 0";
    }*/
}
