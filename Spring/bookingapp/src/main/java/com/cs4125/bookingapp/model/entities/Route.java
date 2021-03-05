package com.cs4125.bookingapp.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer routeId;
    private String startStation;
    private String endStation;
    private String connectionPath;

    public Route(){}

    public Route(String startStation, String endStation, String connectionPath)
    {
        this.startStation = startStation;
        this.endStation = endStation;
        this.connectionPath = connectionPath;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public String getConnectionPath() {
        return connectionPath;
    }

    public void setConnectionPath(String connectionPath)
    {
        this.connectionPath = connectionPath;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", startStation=" + startStation +
                ", endStation=" + endStation +
                ", connectionPath=" + connectionPath +
                '}';
    }
}