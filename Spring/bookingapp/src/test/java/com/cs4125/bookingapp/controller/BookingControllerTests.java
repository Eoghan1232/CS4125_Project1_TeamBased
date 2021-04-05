package com.cs4125.bookingapp.controller;


import com.cs4125.bookingapp.controllers.BookingController;
import com.cs4125.bookingapp.model.repositories.*;
import com.cs4125.bookingapp.services.BookingServiceImpl;
import com.cs4125.bookingapp.services.interceptor.FilterManager;
import com.cs4125.bookingapp.services.interceptor.LogFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class BookingControllerTests {

    private FilterManager myManager;
    private LogFilter logFilter;
    private BookingServiceImpl bookingServiceMock;
    private BookingController bookingControllerMock;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private LogRepository logRepository;


    @BeforeEach
    public void init(){
        myManager = new FilterManager();
        logFilter = new LogFilter(logRepository);
        bookingServiceMock = new BookingServiceImpl(bookingRepository, discountRepository, routeRepository, transactionRepository);
        bookingControllerMock = new BookingController(bookingServiceMock, myManager, logFilter);
    }

    @Test
    public void addNewBookingTest(){
        String message = bookingControllerMock.addNewBooking("N1", "N2", "1", 1.99, "2021-11-30T18:35:24.00Z", 1, 1, "EDRK");
        assertEquals("SUCCESS", message.split(":")[0]);
    }

    @Test
    public void getAllUserBookingsFailTest(){
        String message = bookingControllerMock.getAllBookings(1);
        message = message.split(":")[0];
        assertEquals("FAILURE", message.split("\\[")[1]);
    }

    @Test
    public void getAllUserBookingsTest(){
        bookingControllerMock.addNewBooking("N1", "N2", "1", 1.99, "2021-11-30T18:35:24.00Z", 1, 1, "EDRK");
        String message = bookingControllerMock.getAllBookings(1);
        message = message.split(":")[0];
        assertEquals("SUCCESS", message.split("\\[")[1]);
    }
}
