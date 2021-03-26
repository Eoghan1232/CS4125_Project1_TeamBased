package com.cs4125.bookingapp.model.repositories;

import com.cs4125.bookingapp.model.entities.Booking;
import com.cs4125.bookingapp.model.entities.Connection;
import com.cs4125.bookingapp.model.entities.Node;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeRepository extends CrudRepository<Node, Integer> {
    List<Node> findAll();
    Node findByStationName(String name);
}
