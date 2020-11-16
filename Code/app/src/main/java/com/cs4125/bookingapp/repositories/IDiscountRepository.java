package com.cs4125.bookingapp.repositories;

import com.cs4125.bookingapp.entities.Booking;

public interface IDiscountRepository
{
    public boolean getBooking(Booking booking);
    public boolean deleteBooking(Booking booking);
    public boolean insertBooking(Booking booking);
}
