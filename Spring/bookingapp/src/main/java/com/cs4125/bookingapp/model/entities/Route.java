package com.cs4125.bookingapp.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer route_id;
    private float price;
    private String start_station;
    private String end_station;
    private Timestamp date_time;

    public Route(){}

    public Route(float price, String start_station, String end_station, Timestamp date_time)
    {
        this.price = price;
        this.start_station = start_station;
        this.end_station = end_station;
        this.date_time = date_time;
    }

    public Integer getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Integer route_id) {
        this.route_id = route_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStart_station() {
        return start_station;
    }

    public void setStart_station(String start_station) {
        this.start_station = start_station;
    }

    public String getEnd_station() {
        return end_station;
    }

    public void setEnd_station(String end_station) {
        this.end_station = end_station;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    @Override
    public String toString() {
        return "Route{" +
                "route_id=" + route_id +
                ", price=" + price +
                ", start_station=" + start_station +
                ", end_station=" + end_station +
                ", date_time=" + date_time +
                '}';
    }
}