package com.cs4125.bookingapp.repositories;

import com.cs4125.bookingapp.entities.Discount;

public interface DiscountRepository
{
    void getAllDiscounts(ResultCallback callback);
    void getDiscountById(Discount discount, ResultCallback resultCallback);
    void getDiscountByCode(Discount discount, ResultCallback resultCallback);
    void newDiscount(Discount discount, ResultCallback resultCallback);
    void updateDiscount(Discount discount, ResultCallback resultCallback);
    void removeOldDiscount(Discount discount, ResultCallback resultCallback);
}
