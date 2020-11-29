package com.cs4125.bookingapp.model.repositories;

import com.cs4125.bookingapp.model.entities.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RouteRepository extends CrudRepository<Route, Integer> {
    Route findByStartStationAndEndStationAndDateTime(String startStation, String endStation, Timestamp dateTime);
    List<Route> findAllByStartStationOrEndStationOrDateTime(String startStation, String endStation, Timestamp dateTime);
}
