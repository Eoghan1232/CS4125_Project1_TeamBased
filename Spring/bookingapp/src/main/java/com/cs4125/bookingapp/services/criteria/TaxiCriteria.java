package com.cs4125.bookingapp.services.criteria;

import com.cs4125.bookingapp.model.entities.Connection;

import java.util.ArrayList;
import java.util.List;

public class TaxiCriteria implements Criteria <Connection> {
    @Override
    public List<Connection> meetCriteria(List<Connection> connections){
        List<Connection> taxiConnections = new ArrayList<Connection>();

        for(Connection connection : connections) {
            String[] seperatedTransportTypes = connection.getTransportType().split("&");
            for(String s : seperatedTransportTypes) {
                if(s.equalsIgnoreCase("TAXI")){
                    taxiConnections.add(connection);
                }
            }
        }
        return taxiConnections;
    }
}
