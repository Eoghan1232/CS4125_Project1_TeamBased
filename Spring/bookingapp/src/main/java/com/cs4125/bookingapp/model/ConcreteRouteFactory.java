package com.cs4125.bookingapp.model;

import com.cs4125.bookingapp.model.entities.Route;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ConcreteRouteFactory implements RouteFactory {

    public Route getRoute(String routeType, String start_station, String end_station, Timestamp date_time,  double price) {
        if(routeType == null) {
            return null;
        }
        else if (routeType.equalsIgnoreCase("NORMAL_ROUTE")) {
            return new Route(start_station, end_station, date_time, price);
        }

        return null;
    }
}