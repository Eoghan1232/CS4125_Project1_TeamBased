package com.cs4125.bookingapp.repositories;

import androidx.lifecycle.LiveData;

import com.cs4125.bookingapp.entities.Booking;
import com.cs4125.bookingapp.entities.Route;

public interface BookingRepository
{
    void userBooking(Route route, Booking booking, String discountCode, ResultCallback callback);
    void bookingUpdate(Booking booking, ResultCallback callback);
    void bookingCancel(Booking booking, ResultCallback resultCallback);
    void bookingList(Booking booking, ResultCallback resultCallback);
    void getBooking(Booking booking, ResultCallback resultCallback);
}
