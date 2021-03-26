package com.cs4125.bookingapp.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer bookingId;
    private Integer passengerId;
    private Integer routeId;
    private Integer quantity;
    private Timestamp dateTime;
    private double totalPrice;
    private Integer transactionId;

    public Booking(){}

    public Booking( Integer passengerId, Integer routeId, Integer quantity, Timestamp dateTime, double totalPrice, Integer transactionId) {
        this.passengerId = passengerId;
        this.routeId = routeId;
        this.quantity = quantity;
        this.dateTime = dateTime;
        this.totalPrice = totalPrice;
        this.transactionId = transactionId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", passengerId=" + passengerId +
                ", routeId=" + routeId +
                ", quantity=" + quantity +
                ", dateTime=" + dateTime +
                ", totalPrice=" + totalPrice +
                ", transactionId=" + transactionId +
                '}';
    }
}
