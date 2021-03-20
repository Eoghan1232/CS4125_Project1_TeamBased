package com.cs4125.bookingapp.services.commandDiscount;

import com.cs4125.bookingapp.model.entities.Discount;

import java.util.List;

public class ApplyAllDiscounts implements DiscountOperation
{
    private List<DiscountContext> discounts;

    public ApplyAllDiscounts(List<DiscountContext> discounts)
    {
        this.discounts = discounts;
    }

    @Override
    public void execute()
    {
        for (DiscountContext d : discounts)
        {
            d.applyDiscount();
        }
    }
}
