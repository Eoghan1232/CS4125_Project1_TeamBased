package com.cs4125.bookingapp.repositories;

import com.cs4125.bookingapp.entities.TransactionRecord;

public class PaymentRepository implements IPaymentRepository
{
    @Override
    public boolean getTransaction(TransactionRecord transaction) {
        return false;
    }

    @Override
    public boolean insertTransaction(TransactionRecord transaction) {
        return false;
    }

    @Override
    public boolean updateTransaction(TransactionRecord transaction) {
        return false;
    }
}
