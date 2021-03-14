package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.model.entities.Connection;
import com.cs4125.bookingapp.services.Strategy;

import java.util.List;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public boolean executeStrategy(String startNode, String endNode, List<Connection> connections) {
        return strategy.operation(startNode, endNode, connections);
    }

}
