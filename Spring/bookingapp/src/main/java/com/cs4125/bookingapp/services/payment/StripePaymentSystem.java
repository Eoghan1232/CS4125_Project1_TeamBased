package com.cs4125.bookingapp.services.payment;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

public class StripePaymentSystem implements PaymentSystem {

    private final String stripePublicKey = "pk_test_51IX7WzA4GQu91tA9ygW9sAl0Q42Y0pQYRySwRCSfylSVx9EiL3n691M0ayb6n45E9B7dx8DjfKn1iAwQSrfE24Dn00TDsAbjXU";
    private final String stripeSecretKey = "sk_test_51IX7WzA4GQu91tA9L6s5Nssb1MC2sVodWphIYYApH0ZwzsokQFlLFm44LeDfVvuHlmfdbs8rUpxgxCzMgc98d5ky00v1YjwyaH";

    @Override
    public String initPayment(String details) {
        StringBuilder result = new StringBuilder("FAILURE: ");
        String[] detailParts = details.split(": ");
        double price = -1;
        try {
            if (detailParts.length > 0) {
                for (int i = 0; i < detailParts.length; i++) {
                    if (detailParts[i].equals("Price")) {
                        price = Double.parseDouble(detailParts[i + 1]);
                    }
                }
            }
        }
        catch (Exception e){
            return "FAILURE: 1";
        }
        if (price == -1){
            return "FAILURE: 1";
        }

        Stripe.apiKey = stripeSecretKey;
        PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                .setCurrency("eur")
                .setAmount((long)(price * 100))
                .build();

        try
        {
            PaymentIntent intent = PaymentIntent.create(createParams);
            result = new StringBuilder("SUCCESS: ");
            result.append("publishable_key=")
                    .append(stripePublicKey)
                    .append(",client_secret=")
                    .append(intent.getClientSecret());
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            result.append("1");
            return result.toString();
        }

        return result.toString();
    }

    @Override
    public String confirmPayment(String details) {

        StringBuilder result = new StringBuilder("FAILURE: ");
        String[] detailParts = details.split(": ");
        long transactionId = -1;
        try {
            if (detailParts.length > 0) {
                for (int i = 0; i < detailParts.length; i++) {
                    if (detailParts[i].equals("Transaction ID")) {
                        transactionId = Long.parseLong(detailParts[i + 1]);
                    }
                }
            }
        }
        catch (Exception e){
            return "FAILURE: 1";
        }
        if (transactionId == -1){
            return "FAILURE: 1";
        }

        // TODO: confirm payment for transaction record

        return "SUCCESS: 1";
    }
}
