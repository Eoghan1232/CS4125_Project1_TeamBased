package com.cs4125.bookingapp.services.payment;

import com.stripe.model.Charge;

import java.util.HashMap;
import java.util.Map;

public class StripePaymentSystem implements PaymentSystem {
    @Override
    public void ProcessPayment() {
        System.out.println("Stripe payment ");
    }

    @Override
    public void ProcessPayment(String string) {
        try {
            Map<String, Object> chargeParams = new HashMap<String, Object>();
            //chargeParams.put("amount", (int)(amount * 100));
            chargeParams.put("currency", "EUR");
            //chargeParams.put("source", token);
            Charge charge = Charge.create(chargeParams);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
