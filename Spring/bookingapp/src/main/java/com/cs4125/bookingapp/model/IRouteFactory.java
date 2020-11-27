package com.cs4125.bookingapp.model;

import com.cs4125.bookingapp.model.entities.Route;

import java.sql.Timestamp;

public interface IRouteFactory {
    Route getRoute(String routeType, float price, String start_station, String end_station, Timestamp date_time);
}