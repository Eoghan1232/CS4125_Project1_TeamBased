package com.cs4125.bookingapp.services.payment;

public class CreditCardPayment extends Payment {
    public CreditCardPayment(PaymentSystem payment) {
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
