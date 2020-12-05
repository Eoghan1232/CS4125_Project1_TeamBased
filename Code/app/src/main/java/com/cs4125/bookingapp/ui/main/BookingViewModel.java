package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cs4125.bookingapp.entities.Booking;
import com.cs4125.bookingapp.repositories.BookingRepository;

import okhttp3.ResponseBody;

public class BookingViewModel extends ViewModel
{
    // TODO: Implement the ViewModel
    private BookingRepository repository;

    public void init(BookingRepository repository){
        this.repository = repository;
    }

    public LiveData<String> bookTicket(Booking booking){
        return repository.userBooking(booking);
    }
    //start booking, update booking
    public LiveData<String> updateBooking(Booking booking){
        return repository.bookingUpdate(booking);
    }
}