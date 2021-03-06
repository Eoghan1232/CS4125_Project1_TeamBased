package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.Route;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public interface RouteService {
    String findAllRoutes(String startNodeName, String endNodeName, String dateTime);
    String findAllRoutesFiltered(String startNodeName, String endNodeName, String filters, String dateTime);
    /*
    String searchRoute(int id);
    String searchRoute(String start_station, String end_station, Timestamp date_time);
    List<String> searchAllRoutes(String start_station, String end_station, Timestamp date_time);
    String addRoute(Route r);
    String updateRoute(Route r);
    String deleteRoute(Route r);
     */
}