package com.cs4125.bookingapp.services.pathFinding;

import com.cs4125.bookingapp.model.entities.Connection;
import com.cs4125.bookingapp.model.entities.Route;

import java.util.List;

public interface Strategy {

    List<Route> findPath(String startNode, String endNode, List<Connection> connections);

}
