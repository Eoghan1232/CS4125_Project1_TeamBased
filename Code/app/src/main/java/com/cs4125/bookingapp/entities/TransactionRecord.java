package com.cs4125.bookingapp.entities;

import java.util.Date;

public class TransactionRecord
{
    private final int transactionID;
    private final float amount;
    private Date dateOfPayment;
    private TransactionStatus status;

    public TransactionRecord(int id, float amount)
    {
        this.transactionID = id;
        this.amount = amount;
        this.dateOfPayment = null;
        this.status = TransactionStatus.Pending;
    }

    public TransactionRecord(int id, float amount, Date dateOfPayment, TransactionStatus status)
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

    public Date getDateOfPayment()
    {
        return dateOfPayment;
    }

    public TransactionStatus getStatus()
    {
        return status;
    }
    //endregion

    public void setDateOfPayment(Date dateOfPayment)
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
