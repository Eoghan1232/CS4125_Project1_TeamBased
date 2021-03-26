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
    public double execute(double currentMultiplier)
    {
        double answer = currentMultiplier;
        for (DiscountContext d : discounts)
        {
            answer = d.applyDiscount(answer);
        }

        return answer;
    }
}
