package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.Connection;

import java.util.*;

public class OperationPathFinding implements Strategy {

    @Override
    public boolean operation(String startNode, String endNode, List<Connection> connections) {

        ArrayList<String> settledNodes = new ArrayList<>();
        ArrayList<String> unsettledNodes = new ArrayList<>();

        unsettledNodes.add(startNode);

        while (unsettledNodes.size() != 0){
            String current = unsettledNodes.get(0);
            unsettledNodes.remove(0);

            for(Connection c: connections)
            {
                if(c.getStationOne().equals(current))
                {
                    String temp = c.getStationTwo();
                    if(!settledNodes.contains(temp)){
                        if(temp.equals(endNode))
                        {
                            //return path
                        }
                        else{
                            if(!unsettledNodes.contains(temp))
                            {
                                unsettledNodes.add(temp);
                            }
                        }
                    }
                }
                else if(c.getStationTwo().equals(current))
                {
                    String temp = c.getStationOne();
                    if(!settledNodes.contains(temp)){
                        if(temp.equals(endNode))
                        {
                            //return path
                        }
                        else{
                            if(!unsettledNodes.contains(temp))
                            {
                                unsettledNodes.add(temp);
                            }
                        }
                    }
                }
            }
            settledNodes.add(current);
        }
        return false;
    }
}

class Path{
    String current;
    List<String> previous;

    Path(String c, List<String> p){
        this.current = c;
        this.previous = p;
    }
}