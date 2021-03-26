package com.cs4125.bookingapp.repositories;


import com.cs4125.bookingapp.entities.Route;

public interface RouteRepository
{
    void generateRoutes(String start, String end, String dateTime, ResultCallback callback);
    void generateFilteredRoutes(String start, String end, String filters, String dateTime, ResultCallback callback);
//    void searchAllRoute(Route search, ResultCallback resultCallback);
//    void searchRouteById(Route search, ResultCallback resultCallback);
//    void searchRouteByStationOrDateTime(Route search, ResultCallback resultCallback);
//    void newRoute(Route route, ResultCallback resultCallback);
//    void updateRoute(Route route, ResultCallback resultCallback);
//    void deleteRoute(Route route, ResultCallback resultCallback);
}
