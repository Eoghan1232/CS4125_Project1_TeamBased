package com.cs4125.bookingapp.entities;


import java.sql.Timestamp;

public class TransactionRecord
{
    private final int transactionID;
    private final float amount;
    private Timestamp dateOfPayment;
    private TransactionStatus status;

    public TransactionRecord(int id, float amount)
    {
        this.transactionID = id;
        this.amount = amount;
        this.dateOfPayment = null;
        this.status = TransactionStatus.Pending;
    }

    public TransactionRecord(int id, float amount, Timestamp dateOfPayment, TransactionStatus status)
    {
        this.transactionID = id;
        this.amount = amount;
        this.dateOfPayment = dateOfPayment;
        this.status = status;
    }

    //region Getters
    public int getTransactionID()
    {
        return transactionID;
    }

    public float getAmount()
    {
        return amount;
    }

    public Timestamp getDateOfPayment()
    {
        return dateOfPayment;
    }

    public TransactionStatus getStatus()
    {
        return status;
    }
    //endregion

    public void setDateOfPayment(Timestamp dateOfPayment)
    {
        this.dateOfPayment = dateOfPayment;
    }

    public void setStatus(TransactionStatus newStatus)
    {
        status = newStatus;
    }

    @Override
    public String toString()
    {
        return "TransactionRecord{" + "transactionID=" + transactionID + ", amount=" + amount + ", dateOfPayment=" + dateOfPayment + ", status=" + status + '}';
    }
}
