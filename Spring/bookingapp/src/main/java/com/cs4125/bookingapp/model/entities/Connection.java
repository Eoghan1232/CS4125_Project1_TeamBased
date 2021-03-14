package com.cs4125.bookingapp.model.entities;

import javax.persistence.*;

@Entity
public class Connection {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer connectionId;
    private String stationOne;
    private String stationTwo;
    private String transportType;
    private Double distance;

    public Connection(){}

    public Connection(String stationOne, String stationTwo, String transportType, Double distance) {
        this.stationOne = stationOne;
        this.stationTwo = stationTwo;
        this.transportType = transportType;
        this.distance = distance;
    }

    public Integer getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(Integer connectionId) {
        this.connectionId = connectionId;
    }

    public String getStationOne() {
        return stationOne;
    }

    public void setStationOne(String stationOne) {
        this.stationOne = stationOne;
    }

    public String getStationTwo() {
        return stationTwo;
    }

    public void setStationTwo(String stationTwo) {
        this.stationTwo = stationTwo;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Connection{" +
                "connectionId=" + connectionId +
                ", stationOne=" + stationOne  +
                ", stationTwo=" + stationTwo +
                ", transportType=" + transportType +
                ", distance=" + distance +
                '}';
    }
}