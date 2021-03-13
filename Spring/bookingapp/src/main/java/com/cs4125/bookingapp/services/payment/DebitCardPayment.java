package com.cs4125.bookingapp.services.payment;

public class DebitCardPayment extends Payment {
    @Override
    public void makePayment() {
        payment.ProcessPayment("Debit Card Payment");
    }
}
