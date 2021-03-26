package com.cs4125.bookingapp.services.commandDiscount;

public class DiscountInvoker
{
    private DiscountOperation command;

    public DiscountInvoker(DiscountOperation command)
    {
        this.command = command;
    }

    public double execute(double currentMultiplier)
    {
        return command.execute(currentMultiplier);
    }
}
