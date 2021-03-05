package com.cs4125.bookingapp.model.repositories;

import com.cs4125.bookingapp.model.entities.Booking;
import com.cs4125.bookingapp.model.entities.Connection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionRepository extends CrudRepository<Connection, Integer> {
    List<Connection> findAll();
}
