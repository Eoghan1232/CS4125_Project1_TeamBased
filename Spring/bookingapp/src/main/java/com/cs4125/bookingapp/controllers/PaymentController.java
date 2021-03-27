package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.services.payment.CreditCardPayment;
import com.cs4125.bookingapp.services.payment.DebitCardPayment;
import com.cs4125.bookingapp.services.payment.Payment;
import com.cs4125.bookingapp.services.payment.StripePaymentSystem;
import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Event;
import com.stripe.model.PaymentIntent;
import com.stripe.net.Webhook;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

@RestController
public class PaymentController {
    private final String stripePublicKey = "pk_test_51IX7WzA4GQu91tA9ygW9sAl0Q42Y0pQYRySwRCSfylSVx9EiL3n691M0ayb6n45E9B7dx8DjfKn1iAwQSrfE24Dn00TDsAbjXU";
    private final String stripeSecretKey = "sk_test_51IX7WzA4GQu91tA9L6s5Nssb1MC2sVodWphIYYApH0ZwzsokQFlLFm44LeDfVvuHlmfdbs8rUpxgxCzMgc98d5ky00v1YjwyaH";
    private final String webhook = "whsec_6NH5GgR2e4hxyqgVWpElD83upKfhfSi2";


    @PostMapping(path="/stripe/createpaymentintent")
    @ResponseBody
    public String getPaymentIntent(@RequestParam String paymentType, @RequestParam double price)
    {
        Payment stripePayment;
        if (paymentType.equals("Credit")){
            stripePayment = new CreditCardPayment(new StripePaymentSystem());
        }
        else if (paymentType.equals("Debit")){
            stripePayment = new DebitCardPayment(new StripePaymentSystem());
        }
        else {
            return "FAILURE: 0";
        }

        return stripePayment.startPayment("Price: " + price);
    }

    @PostMapping(path="/stripe/confirmpayment")
    @ResponseBody
    public String confirmPayment(@RequestParam String paymentType, @RequestParam long transactionId)
    {
        Payment stripePayment;
        if (paymentType.equals("Credit")){
            stripePayment = new CreditCardPayment(new StripePaymentSystem());
        }
        else if (paymentType.equals("Debit")){
            stripePayment = new DebitCardPayment(new StripePaymentSystem());
        }
        else {
            return "FAILURE: 0";
        }
        return stripePayment.endPayment("Transaction ID: " + transactionId);
    }

    //This is for stripe to confirm a payment with our backend
    @PostMapping("/stripe/webhook")
    public void confirmPayment(HttpServletRequest request, HttpServletResponse response)
    {
        Stripe.apiKey = stripeSecretKey;
//        String payload = request.body();
//        String signature = request.headers("Stripe-Signature");
//        Event event = null;

        try {
            String payload = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

            if (!StringUtils.isEmpty(payload)) {
                String sigHeader = request.getHeader("Stripe-Signature");

                Event event = Webhook.constructEvent(payload, sigHeader, webhook);

                switch(event.getType())
                {
                    case "payment_intent.succeeded":
                        System.out.println("Payment successful!");
                        break;
                    case "payment_intent.payment_failed":
                        System.out.println("Payment Failed!");
                        break;
                    default:
                        System.out.println("Stripe Webhook unsupported event type!");
                }

                response.setStatus(200);
            }

        } catch (Exception e) {
            response.setStatus(500);
        }

//        try
//        {
//            event = Webhook.constructEvent(payload, signature, webhook);
//        }
//        catch(SignatureVerificationException e)
//        {
//            return "FAILURE: 1";
//        }
//
//        switch(event.getType())
//        {
//            case "payment_intent.succeeded":
//                return "SUCCESS";
//            case "payment_intent.payment_failed":
//                return "FAILURE: 2";
//            default:
//                return "FAILURE: 3";
//        }
    }
}
