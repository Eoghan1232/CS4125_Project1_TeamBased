package com.cs4125.bookingapp.controller;


import com.cs4125.bookingapp.controllers.PaymentController;
import com.cs4125.bookingapp.model.repositories.LogRepository;
import com.cs4125.bookingapp.model.repositories.TransactionRepository;
import com.cs4125.bookingapp.services.interceptor.FilterManager;
import com.cs4125.bookingapp.services.interceptor.LogFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PaymentControllerTests {
    private FilterManager myManager;
    private LogFilter logFilter;
    private PaymentController paymentControllerMock;
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private TransactionRepository transactionRepository;


    @BeforeEach
    public void init(){
        myManager = new FilterManager();
        logFilter = new LogFilter(logRepository);
        paymentControllerMock = new PaymentController();
    }

    @Test
    public void getPaymentIntentTest(){
        String message = paymentControllerMock.getPaymentIntent("Credit", 10);
        assertEquals("SUCCESS", message.split(":")[0]);

        message = paymentControllerMock.getPaymentIntent("Debit", 10);
        assertEquals("SUCCESS", message.split(":")[0]);
    }
}
