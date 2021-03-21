package com.cs4125.bookingapp.services.pathFinding;

import com.cs4125.bookingapp.model.entities.Connection;
import com.cs4125.bookingapp.model.entities.Route;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PathFindingContext {

    private Strategy strategy;

    public PathFindingContext(){

    }

    public PathFindingContext(Strategy strategy){
        this.strategy = strategy;
    }

    public List<Route> executeStrategy(String startNode, String endNode, List<Connection> connections) {
        return strategy.findPath(startNode, endNode, connections);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
