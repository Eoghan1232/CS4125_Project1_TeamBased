package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.Connection;

import java.util.List;

public interface Strategy {

    boolean operation(String startNode, String endNode, List<Connection> connections);

}
