package com.cs4125.bookingapp.repositories;

public interface PaymentRepository
{
    void getPaymentIntent(String paymentType, double price, ResultCallback callback);
}
