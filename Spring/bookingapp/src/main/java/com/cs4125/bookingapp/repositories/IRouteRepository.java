package com.cs4125.bookingapp.repositories;

import com.cs4125.bookingapp.entities.Route;
import org.springframework.data.repository.CrudRepository;

public interface IRouteRepository extends CrudRepository<Route, Integer> {
}
