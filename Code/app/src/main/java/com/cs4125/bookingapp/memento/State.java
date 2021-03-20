package com.cs4125.bookingapp.memento;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class State {
    private String route;
    private String quantity;
    private String discount;

    private String from;
    private String to;
    private String date; // this wont work
    private String time; // this wont work either
    private Chip filter;

    public State(String route, String quantity, String discount){
        this.route = route;
        this.quantity = quantity;
        this.discount = discount;
    }

    public State(String from, String to, String date, String time, Chip filter){
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
        this.filter = filter;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Chip getFilter() {
        return filter;
    }

    public void setFilter(Chip filter) {
        this.filter = filter;
    }
}
