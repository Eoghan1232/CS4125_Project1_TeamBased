package com.cs4125.bookingapp.services.payment;

public abstract class Payment {
    PaymentSystem payment;

    public Payment(PaymentSystem payment) {
        this.payment = payment;
    }

    public abstract String startPayment(String details);
    public abstract String endPayment(String details);

}
