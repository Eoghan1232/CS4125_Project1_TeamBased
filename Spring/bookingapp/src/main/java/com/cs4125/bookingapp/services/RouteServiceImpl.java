package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.Route;
import com.cs4125.bookingapp.services.abstractFactory.AbstractCriteriaFactory;
import com.cs4125.bookingapp.services.abstractFactory.CriteriaFactoryProducer;
import com.cs4125.bookingapp.services.interceptor.Target;
import com.cs4125.bookingapp.services.pathFinding.PathFindingContext;
import com.cs4125.bookingapp.model.entities.Connection;
import com.cs4125.bookingapp.model.repositories.ConnectionRepository;
import com.cs4125.bookingapp.model.repositories.NodeRepository;
import com.cs4125.bookingapp.model.repositories.RouteRepository;
import com.cs4125.bookingapp.services.criteria.*;
import com.cs4125.bookingapp.services.pathFinding.ShortestPathStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RouteServiceImpl implements RouteService, Target {

    private final RouteRepository routeRepository;
    private final NodeRepository nodeRepository;
    private final ConnectionRepository connectionRepository;
    private final PathFindingContext pathFindingContext;
    private AbstractCriteriaFactory<?> criteriaFactory;
    private PriceCalculation priceCalculation;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, NodeRepository nodeRepository, ConnectionRepository connectionRepository, PathFindingContext pathFindingContext) {
        this.routeRepository = routeRepository;
        this.nodeRepository = nodeRepository;
        this.connectionRepository = connectionRepository;
        this.pathFindingContext = pathFindingContext;
    }

    @Override
    public String execute(String request) {

        String result = "";
        String str[] = request.split(",");

        switch(str[0]) {
            case("generateAllRoutes"):
                result = findAllRoutes(str[1], str[2], str[3]);
                break;
            case("generateFilteredRoutes"):
                result = findAllRoutesFiltered(str[1], str[2], str[3], str[4]);
                break;
            default:
                return "FAILURE: 1";
        }
        return result;
    }

    @Override
    public String findAllRoutes(String startNodeName, String endNodeName, String dateTime)
    {
        // Get connections
        List<Connection> connectionList = connectionRepository.findAll();

        // Get paths
        pathFindingContext.setStrategy(new ShortestPathStrategy());
        List<Route> routeList = pathFindingContext.executeStrategy(startNodeName, endNodeName, connectionList);

        // Check if any paths were found
        if(routeList.size() <= 0)
        {
            return "FAILURE: 1";
        }

        // Calculate prices
        priceCalculation = new PriceCalculation("ALL", connectionList);

        return getResultString(routeList, dateTime);
    }

    @Override
    public String findAllRoutesFiltered(String startNodeName, String endNodeName, String filters, String dateTime)
    {
        // Get the required criteria
        criteriaFactory = CriteriaFactoryProducer.getFactory("CONNECTION");
        Criteria criteria = criteriaFactory.getCriteria(filters);
        if(criteria == null)
            return "FAILURE: 1";
        /* Old criteria initialization before abstract factory
        switch(filters) {
            case("WALK"):
                criteria = new WalkCriteria();
                break;
            case("BUS"):
                criteria = new BusCriteria();
                break;
            case("CAR"):
                criteria = new CarCriteria();
                break;
            case("BIKE"):
                criteria = new BikeCriteria();
                break;
            case("UBER"):
                criteria = new UberCriteria();
                break;
            case("TAXI"):
                criteria = new TaxiCriteria();
                break;
            case("TRAIN"):
                criteria = new TrainCriteria();
                break;
            case("PLANE"):
                criteria = new PlaneCriteria();
                break;
            default:
                return "FAILURE: 1";
        }
         */

        // Get filtered connections
        List<Connection> connectionList = criteria.meetCriteria(connectionRepository.findAll());

        // Get paths
        pathFindingContext.setStrategy(new ShortestPathStrategy());
        List<Route> routeList = pathFindingContext.executeStrategy(startNodeName, endNodeName, connectionList);

        // Check if any paths were found
        if(routeList.size() <= 0)
        {
            return "FAILURE: 1";
        }

        // Calculate prices
        priceCalculation = new PriceCalculation(filters, connectionList);

        return getResultString(routeList, dateTime);
    }

    private String getResultString(List<Route> routeList, String dateTime)
    {
        List<Double> prices = priceCalculation.getPrices(routeList);
        int counter = 0;

        //System.out.println(prices);
        if(prices.size() != routeList.size())
        {
            return "FAILURE: 2";
        }

        StringBuilder result = new StringBuilder("SUCCESS: ");
        for(int i = 0; i < routeList.size(); i++)
        {
            if(prices.get(i) < 0)
                continue;

            String routeString = routeList.get(i).toString();
            result.append(routeString.substring(0, routeString.length() - 1))
                    .append(", price=")
                    .append(prices.get(i))
                    .append(", dateTime=")
                    .append(dateTime)
                    .append("}");
            counter++;
        }

        // No prices for the routes
        if(counter == 0)
            return "FAILURE: 3";

        return result.toString();
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
