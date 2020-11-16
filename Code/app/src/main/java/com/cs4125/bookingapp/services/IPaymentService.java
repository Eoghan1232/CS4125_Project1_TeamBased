package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.entities.Discount;

import java.util.List;

public interface IPaymentService
{
    boolean pay();
    boolean cancelPayment();
}
