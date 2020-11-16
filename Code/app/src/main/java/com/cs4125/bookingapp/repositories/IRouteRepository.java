package com.cs4125.bookingapp.repositories;

import com.cs4125.bookingapp.entities.Route;

public interface IRouteRepository
{
    public boolean insertRoute(Route route);
    public boolean deleteRoute(Route route);
    public boolean updateRoute(Route route);
}
