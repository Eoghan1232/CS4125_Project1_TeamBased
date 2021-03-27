package com.cs4125.bookingapp.services.payment;

public class DebitCardPayment extends Payment {
    public DebitCardPayment(PaymentSystem payment) {
        super(payment);
    }

    @Override
    public String startPayment(String details) {

        return payment.initPayment(details);
    }
    public String endPayment(String details) {
        return payment.confirmPayment(details);
    }
}
