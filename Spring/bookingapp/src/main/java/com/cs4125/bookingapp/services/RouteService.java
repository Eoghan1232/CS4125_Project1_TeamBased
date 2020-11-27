package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.Route;
import com.cs4125.bookingapp.model.entities.User;
import com.cs4125.bookingapp.model.repositories.IRouteRepository;
import com.cs4125.bookingapp.model.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.*;

public class RouteService implements IRouteService {

    @Autowired
    private IRouteRepository routeRepository;

    /**
     * Searches route by stations and datetime
     * @param id id of the route
     * @return SUCCESS: route information if found the route, else FAILURE: error code
     */
    @Override
    public String searchRoute(int id) {
        Route resRoute = routeRepository.findById(id).orElse(null);
        if(resRoute == null) {
            return "FAILURE: 1";
        }

        return "SUCCESS: " + resRoute.toString();
    }

    /**
     * Searches route by stations and datetime
     * @param start_station name of start station
     * @param end_station name of end station
     * @param date_time date and time of the route
     * @return SUCCESS: route information if found the route, else FAILURE: error code
     */
    @Override
    public String searchRoute(String start_station, String end_station, Timestamp date_time) {
        Route resRoute = routeRepository.findByStart_stationAndEnd_stationAndDate_time(start_station, end_station, date_time);
        if(resRoute == null) {
            return "FAILURE: 1";
        }

        return "SUCCESS: " + resRoute.toString();
    }

    /**
     * Searches all routes by any combination of the given parameters
     * @param start_station name of start station
     * @param end_station name of end station
     * @param date_time date and time of the route
     * @return List of strings containing information of the found routes, if none found will return List with FAILURE: error code
     */
    @Override
    public List<String> searchAllRoutes(String start_station, String end_station, Timestamp date_time) {

        List<Route> matchedRoutes = routeRepository.findAllByStart_stationOrEnd_stationOrDate_time(start_station, end_station, date_time);
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

    /**
     * Add a new route
     * @param r route to be added
     * @return SUCCESS: routeid if adding was successful, else FAILURE: error code
     */
    @Override
    public String addRoute(Route r) {
        Route routeCheck = routeRepository.findByStart_stationAndEnd_stationAndDate_time(r.getStart_station(), r.getEnd_station(), r.getDate_time());
        if (routeCheck != null) {
            return "FAILURE: 1";
        }
        r = routeRepository.save(r);

        return "SUCCESS: " + r.getRoute_id();
    }

    /**
     * Update a route
     * @param r route with updated variables
     * @return SUCCESS: routeid if update was successful, else FAILURE: error code
     */
    @Override
    public String updateRoute(Route r) {
        // no id supplied
        if (r.getRoute_id() == 0) {
            return "FAILURE: 1";
        }

        if (!routeRepository.existsById(r.getRoute_id())) {
            return "FAILURE: 2";
        }
        // if there is route with given id already save() will update the entry
        r = routeRepository.save(r);

        return "SUCCESS: " + r.getRoute_id();
    }

    /**
     * Delete a route
     * @param r route to be deleted
     * @return SUCCESS: 0 if deletion was successful, else FAILURE: error code
     */
    @Override
    public String deleteRoute(Route r) {
        // no id supplied
        if (r.getRoute_id() == 0) {
            return "FAILURE: 1";
        }

        if (!routeRepository.existsById(r.getRoute_id())) {
            return "FAILURE: 2";
        }

        // Delete route and check if deletion was successful
        routeRepository.deleteById(r.getRoute_id());
        if (routeRepository.existsById(r.getRoute_id())) {
            return "FAILURE: 3";
        }

        return "SUCCESS: 0";
    }
}
