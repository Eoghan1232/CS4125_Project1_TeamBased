package com.cs4125.bookingapp.services.payment;

public class CreditCardPayment extends Payment {
    @Override
    public void makePayment() {
        payment.ProcessPayment("Credit Card Payment");
    }
}
