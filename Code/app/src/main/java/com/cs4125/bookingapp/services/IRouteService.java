package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.entities.Route;

import java.util.List;

public interface IRouteService
{
    List<Route> searchRoutes();
    boolean createNewRoute(Route route);
    boolean deleteOldRoute(Route route);
    boolean modifyOldRoute(Route route);
}
