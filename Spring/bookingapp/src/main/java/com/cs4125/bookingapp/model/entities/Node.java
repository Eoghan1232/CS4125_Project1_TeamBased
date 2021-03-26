package com.cs4125.bookingapp.model.entities;

import javax.persistence.*;

@Entity
public class Node {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer nodeId;
    private String stationName;
    private String stationDescriptions;

    public Node(){}

    public Node(String stationName, String stationDescriptions) {
        this.stationName = stationName;
        this.stationDescriptions = stationDescriptions;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeID(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationDescriptions() {
        return stationDescriptions;
    }

    public void setStationDescriptions(String stationDescriptions) {
        this.stationDescriptions = stationDescriptions;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeId=" + nodeId +
                ", nodeName=" + stationName +
                ", nodeStation=" + stationDescriptions +
                '}';
    }
}