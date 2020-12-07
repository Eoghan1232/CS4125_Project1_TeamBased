package com.cs4125.bookingapp.repositories;


import com.cs4125.bookingapp.entities.Route;

public interface RouteRepository
{
    void searchAllRoute(Route search, ResultCallback resultCallback);
    void searchRouteById(Route search, ResultCallback resultCallback);
    void searchRouteByStationOrDateTime(Route search, ResultCallback resultCallback);
    void newRoute(Route route, ResultCallback resultCallback);
    void updateRoute(Route route, ResultCallback resultCallback);
    void deleteRoute(Route route, ResultCallback resultCallback);
}
