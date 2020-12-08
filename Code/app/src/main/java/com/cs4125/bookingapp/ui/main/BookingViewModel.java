package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cs4125.bookingapp.entities.Booking;
import com.cs4125.bookingapp.repositories.BookingRepository;
import com.cs4125.bookingapp.repositories.BookingRepositoryImpl;
import com.cs4125.bookingapp.repositories.ResultCallback;

import okhttp3.ResponseBody;

public class BookingViewModel extends ViewModel
{
    private BookingRepository repository;


    public void init(){
        this.repository = new BookingRepositoryImpl();
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
    public String payForBooking(Booking booking){
        final String[] r = new String[1];
        repository.bookingUpdate(booking, new ResultCallback()
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

    public String cancelBooking(Booking booking){
        final String[] r = new String[1];
        repository.bookingCancel(booking, new ResultCallback()
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

    public String allBooking(Booking booking){
        final String[] r = new String[1];
        repository.bookingList(booking, new ResultCallback()
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
}
