package com.cs4125.bookingapp.repositories;

public interface PaymentRepository
{
    void getPaymentIntent(double price, ResultCallback callback);
}
