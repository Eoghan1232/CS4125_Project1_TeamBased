package com.cs4125.bookingapp.repositories;

import androidx.lifecycle.LiveData;

import com.cs4125.bookingapp.entities.Booking;

public interface BookingRepository
{
    LiveData<String> userBooking(Booking booking, String discountCode);

    LiveData<String> bookingUpdate(Booking booking);
}
