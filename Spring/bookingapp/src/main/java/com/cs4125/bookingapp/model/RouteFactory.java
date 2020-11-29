package com.cs4125.bookingapp.model;

import com.cs4125.bookingapp.model.entities.Route;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public interface RouteFactory {
    Route getRoute(String routeType, String start_station, String end_station, Timestamp date_time, double price);
}