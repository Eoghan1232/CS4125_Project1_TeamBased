package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cs4125.bookingapp.entities.Booking;
import com.cs4125.bookingapp.repositories.BookingRepository;
import com.cs4125.bookingapp.repositories.ResultCallback;

import okhttp3.ResponseBody;

public class BookingViewModel extends ViewModel
{
    // TODO: Implement the ViewModel
    private BookingRepository repository;

    public void init(BookingRepository repository){
        this.repository = repository;
    }

    public String bookTicket(Booking booking, String code){
        final String[] r = new String[1];
        repository.userBooking(booking, code, new ResultCallback()
        {
            @Override
            public void onResult(String result)
            {
                r[0] = result;
            }

            @Override
            public void onFailure(Throwable error)
            {
                r[0] = error.toString();
            }
        });

        return r[0];
    }
    //start booking, update booking
    public LiveData<String> updateBooking(Booking booking){
        //return repository.bookingUpdate(booking);
        return null;
    }
}