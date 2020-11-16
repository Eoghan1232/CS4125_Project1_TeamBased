package com.cs4125.bookingapp.repositories;

import com.cs4125.bookingapp.entities.TransactionRecord;

public interface IPaymentRepository
{
    public boolean getTransaction(TransactionRecord transaction);
    public boolean insertTransaction(TransactionRecord transaction);
    public boolean updateTransaction(TransactionRecord transaction);
}
