package com.cs4125.bookingapp.controller;


import com.cs4125.bookingapp.controllers.DiscountController;
import com.cs4125.bookingapp.model.repositories.DiscountRepository;
import com.cs4125.bookingapp.model.repositories.LogRepository;
import com.cs4125.bookingapp.services.DiscountService;
import com.cs4125.bookingapp.services.DiscountServiceImpl;
import com.cs4125.bookingapp.services.interceptor.FilterManager;
import com.cs4125.bookingapp.services.interceptor.LogFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class DiscountControllerTests {

    private FilterManager myManager;
    private LogFilter logFilter;
    private DiscountServiceImpl discountServiceMock;
    private DiscountController discountControllerMock;
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private LogRepository logRepository;

    @BeforeEach
    public void init(){
        myManager = new FilterManager();
        logFilter = new LogFilter(logRepository);
        discountServiceMock = new DiscountServiceImpl(discountRepository);
        discountControllerMock = new DiscountController(discountServiceMock, myManager, logFilter);
    }

    @Test
    public void addNewDiscountTest(){
        List<String> temp = new ArrayList<>();
        temp.add("1");
        String message = discountControllerMock.addNewDiscount("ERJK", temp, 11);
        assertEquals("SUCCESS", message.split(":")[0]);
    }

    @Test
    public void getAllDiscountsFailTest(){
        String message = discountControllerMock.getAllDiscount();
        message = message.split(":")[0];
        assertEquals("FAILURE", message.split("\\[")[1]);
    }

    @Test
    public void getAllDiscountsTest(){
        List<String> temp = new ArrayList<>();
        temp.add("1");
        discountControllerMock.addNewDiscount("ERJK", temp, 11);
        String message = discountControllerMock.getAllDiscount();
        message = message.split(":")[0];
        assertEquals("SUCCESS", message.split("\\[")[1]);

    }
}
