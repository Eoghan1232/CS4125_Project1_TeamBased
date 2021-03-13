package com.cs4125.bookingapp.repositories;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.cs4125.bookingapp.entities.Booking;
import com.cs4125.bookingapp.entities.Route;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class BookingRepositoryCacheProxy implements BookingRepository, Serializable
{
    private BookingRepository bookingRepository;
    private ConcurrentHashMap<Integer, String> cachedResults;
    private Date lastUpdate;

    public BookingRepositoryCacheProxy()
    {
        bookingRepository = new BookingRepositoryImpl();
        cachedResults = new ConcurrentHashMap<>();
    }

    @Override
    public void userBooking(Route route, Booking booking, String discountCode, ResultCallback callback)
    {
        bookingRepository.userBooking(route, booking, discountCode, callback);
    }

    @Override
    public void bookingUpdate(Booking booking, ResultCallback callback)
    {
        bookingRepository.bookingUpdate(booking, callback);
    }

    @Override
    public void bookingList(Booking booking, ResultCallback resultCallback)
    {
        long diffMinutes = 99;
        long diffHours = 99;
        if(lastUpdate != null)
        {
            long diffInMillis = Calendar.getInstance().getTime().getTime() - lastUpdate.getTime();
            diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
            diffHours = TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
        }

        if (diffHours < 1 && diffMinutes < 20 && cachedResults.containsKey(booking.getPassengerID()))
        {
            resultCallback.onResult(cachedResults.get(booking.getPassengerID()));
        }
        else
        {
            lastUpdate = Calendar.getInstance().getTime();
            // for this we need to store the result from the request if it was successful
            // otherwise just send back the error received
            bookingRepository.bookingList(booking, new ResultCallback()
            {
                @Override
                public void onResult(String result)
                {
                    cachedResults.put(booking.getPassengerID(), result);
                    resultCallback.onResult(result);
                }

                @Override
                public void onFailure(Throwable error)
                {
                    resultCallback.onFailure(error);
                }
            });
        }
    }

    @Override
    public void getBooking(Booking booking, ResultCallback resultCallback)
    {
        if(cachedResults.containsKey(booking.getBookingID()))
        {
            resultCallback.onResult(cachedResults.get(booking.getBookingID()));
        }
        else
        {
            bookingRepository.bookingList(booking, new ResultCallback()
            {
                @Override
                public void onResult(String result)
                {
                    cachedResults.put(booking.getBookingID(), result);
                    resultCallback.onResult(result);
                }

                @Override
                public void onFailure(Throwable error)
                {
                    resultCallback.onFailure(error);
                }
            });
        }
    }

    @Override
    public void bookingCancel(Booking booking, ResultCallback resultCallback)
    {
        bookingRepository.bookingCancel(booking, resultCallback);
    }

    public void resetCache()
    {
        cachedResults.clear();
    }
}
