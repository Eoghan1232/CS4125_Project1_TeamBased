package com.cs4125.bookingapp.services.payment;

public interface PaymentSystem {
    String initPayment(String details);
    String confirmPayment(String details);
}
