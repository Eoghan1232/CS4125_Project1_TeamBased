package com.cs4125.bookingapp.model.repositories;

import com.cs4125.bookingapp.model.entities.Route;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface IRouteRepository extends CrudRepository<Route, Integer> {
    Route findByStart_stationAndEnd_stationAndDate_time(String start_station, String end_station, Timestamp date_time);
    List<Route> findAllByStart_stationOrEnd_stationOrDate_time(String start_station, String end_station, Timestamp date_time);
}
