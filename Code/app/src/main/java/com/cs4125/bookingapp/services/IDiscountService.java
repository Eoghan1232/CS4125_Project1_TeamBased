package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.entities.Discount;
import com.cs4125.bookingapp.entities.Route;

import java.util.List;

public interface IDiscountService
{
    List<Discount> searchDiscount(Discount discount);
    boolean createNewDiscount(Discount discount);
    boolean removeOldDiscount(Discount discount);
}
