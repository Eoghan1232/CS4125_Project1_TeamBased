package com.cs4125.bookingapp.services.commandDiscount;

import com.cs4125.bookingapp.model.entities.Discount;

public class DiscountContext
{
    private Discount discount;
    private boolean isApplied;

    public DiscountContext(Discount discount)
    {
        this.discount = discount;
        this.isApplied = false;
    }

    public double applyDiscount(double currentMultiplier)
    {
        if(discount == null)
            return currentMultiplier;

        double answer = currentMultiplier;
        if(isApplied)
        {
            System.out.println("Discount already applied!");
        }
        else
        {
            //System.out.println("Apply discount: " + (discount.getDiscountPercent() / 100) + "%");
            isApplied = true;
            answer = answer - discount.getDiscountPercent() / 100;
        }

        return answer;
    }
}
