package com.cs4125.bookingapp.services.payment;

public class PaypalPaymentSystem implements PaymentSystem {
    @Override
    public void ProcessPayment(String string) {
        System.out.println("Paypal payment " + string);
    }

    public void ProcessPayment() {
        System.out.println("User will pay on delivery");
    }
}
