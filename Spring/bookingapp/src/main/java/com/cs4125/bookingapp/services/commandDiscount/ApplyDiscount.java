package com.cs4125.bookingapp.services.commandDiscount;

import com.cs4125.bookingapp.model.entities.Discount;

public class ApplyDiscount implements DiscountOperation
{
    private DiscountContext discount;

    public ApplyDiscount(DiscountContext discount)
    {
        this.discount = discount;
    }

    @Override
    public void execute()
    {
        discount.applyDiscount();
    }
}
