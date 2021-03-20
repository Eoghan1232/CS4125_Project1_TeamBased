package com.cs4125.bookingapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer discountId;
    private String code;
    private String transportTypes;
    private double discountPercent;

    public Discount(){}

    public Discount(String code, String transportTypes, double discountPercent) {
        this.code = code;
        this.transportTypes = transportTypes;
        this.discountPercent = discountPercent;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTransportTypes() {
        return transportTypes;
    }

    public void setTransportTypes(String transportTypes) {
        this.transportTypes = transportTypes;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountId=" + discountId +
                ", code=" + code +
                ", transportTypes=" + transportTypes +
                ", discountPercent=" + discountPercent +
                '}';
    }
}
