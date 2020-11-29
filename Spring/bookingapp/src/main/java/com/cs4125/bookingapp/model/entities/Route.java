package com.cs4125.bookingapp.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer routeId;
    private String startStation;
    private String endStation;
    private Timestamp dateTime;
    private double price;

    public Route(){}

    public Route(String startStation, String endStation, Timestamp dateTime, double price)
    {
        this.startStation = startStation;
        this.endStation = endStation;
        this.dateTime = dateTime;
        this.price = price;
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

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", startStation=" + startStation +
                ", endStation=" + endStation +
                ", dateTime=" + dateTime +
                ", price=" + price +
                '}';
    }
}