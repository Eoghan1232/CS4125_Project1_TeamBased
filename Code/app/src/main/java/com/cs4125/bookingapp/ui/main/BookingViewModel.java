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

    public LiveData<ResponseBody> bookingTicket(Booking booking){
        return repository.userBooking(booking);
    }
}