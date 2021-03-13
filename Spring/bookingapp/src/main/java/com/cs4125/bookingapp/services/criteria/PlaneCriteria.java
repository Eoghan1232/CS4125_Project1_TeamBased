package com.cs4125.bookingapp.services.criteria;

import com.cs4125.bookingapp.model.entities.Connection;

import java.util.ArrayList;
import java.util.List;

public class PlaneCriteria implements Criteria <Connection> {
    @Override
    public List<Connection> meetCriteria(List<Connection> connections){
        List<Connection> planeConnections = new ArrayList<Connection>();

        for(Connection connection : connections) {
            String[] seperatedTransportTypes = connection.getTransportType().split("&");
            for(String s : seperatedTransportTypes) {
                if(s.equalsIgnoreCase("PLANE")){
                    planeConnections.add(connection);
                }
            }
        }
        return planeConnections;
    }
}