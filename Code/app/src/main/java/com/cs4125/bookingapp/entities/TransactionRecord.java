package com.cs4125.bookingapp.entities;

import java.util.Date;

public class TransactionRecord
{
    private final long transactionID;
    private final float amount;
    private Date dateOfPayment;
    private TransactionStatus status;

    public TransactionRecord(long id, float amount)
    {
        this.transactionID = id;
        this.amount = amount;
        this.dateOfPayment = null;
        this.status = TransactionStatus.Pending;
    }

    public TransactionRecord(long id, float amount, Date dateOfPayment, TransactionStatus status)
    {
        this.transactionID = id;
        this.amount = amount;
        this.dateOfPayment = dateOfPayment;
        this.status = status;
    }

    //region Getters
    public long getTransactionID()
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
