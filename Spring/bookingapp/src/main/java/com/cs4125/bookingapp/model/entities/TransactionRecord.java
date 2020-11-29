package com.cs4125.bookingapp.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="transactionrecord")
public class TransactionRecord {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer transactionId;
    private double amount;
    private Timestamp dateOfPayment;
    private int status;

    public TransactionRecord(){}

    public TransactionRecord(double amount, Timestamp dateOfPayment) {
        this.amount = amount;
        this.dateOfPayment = dateOfPayment;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Timestamp dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TransactionRecord{" +
                "transactionId=" + transactionId +
                ", amount=" + amount +
                ", dateOfPayment=" + dateOfPayment +
                ", status=" + status +
                '}';
    }
}
