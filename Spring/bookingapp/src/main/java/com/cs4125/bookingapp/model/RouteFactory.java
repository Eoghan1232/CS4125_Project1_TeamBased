package com.cs4125.bookingapp.model;

import com.cs4125.bookingapp.model.entities.Route;

import java.sql.Timestamp;

public class RouteFactory implements IRouteFactory {

    public Route getRoute(String routeType, float price, String start_station, String end_station, Timestamp date_time) {
        if(routeType == null) {
            return null;
        }
        else if (routeType.equalsIgnoreCase("NORMAL_ROUTE")) {
            return new Route(price, start_station, end_station, date_time);
        }

        return null;
    }
}