package com.cs4125.bookingapp.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="transactionrecord")
public class TransactionRecord {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer transaction_id;
    private float amount;
    private Timestamp date_of_payment;
    private String status;

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Timestamp getDate_of_payment() {
        return date_of_payment;
    }

    public void setDate_of_payment(Timestamp date_of_payment) {
        this.date_of_payment = date_of_payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
