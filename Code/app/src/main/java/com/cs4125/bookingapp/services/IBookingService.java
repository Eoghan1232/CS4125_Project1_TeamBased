package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.entities.Booking;
import com.cs4125.bookingapp.entities.User;

public interface IBookingService
{
    boolean createNewBooking(Booking booking);
    boolean cancelOldBooking(Booking booking);
    boolean applyDiscount(Booking booking);
}
