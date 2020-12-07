package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cs4125.bookingapp.entities.Booking;
import com.cs4125.bookingapp.entities.Discount;
import com.cs4125.bookingapp.entities.Route;
import com.cs4125.bookingapp.entities.User;
import com.cs4125.bookingapp.repositories.BookingRepositoryImpl;
import com.cs4125.bookingapp.repositories.DiscountRepository;
import com.cs4125.bookingapp.repositories.DiscountRepositoryImpl;
import com.cs4125.bookingapp.repositories.ResultCallback;
import com.cs4125.bookingapp.repositories.RouteRepository;
import com.cs4125.bookingapp.repositories.RouteRepositoryImpl;
import com.cs4125.bookingapp.repositories.UserRepository;
import com.cs4125.bookingapp.repositories.BookingRepository;
import com.cs4125.bookingapp.repositories.BookingRepositoryImpl;

import okhttp3.Response;

//Admin not implemented yet, created for future implementation
public class AdminViewModel extends ViewModel
{
    private DiscountRepository repository;
    private BookingRepository repository2;
    private RouteRepository repository3;

    public void init(){
        this.repository = new DiscountRepositoryImpl();
        this.repository2 = new BookingRepositoryImpl();
        this.repository3 = new RouteRepositoryImpl();
    }

    public String getAllDiscounts(){
        final String[] r = new String[1];
        repository.getAllDiscounts(new ResultCallback()
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
    public String getDiscountById(Discount discount){
        final String[] r = new String[1];
        repository.getDiscountById(discount, new ResultCallback()
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
    public String getDiscountByCode(Discount discount){
        final String[] r = new String[1];
        repository.getDiscountByCode(discount, new ResultCallback()
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
    public String newDiscount(Discount discount){
        final String[] r = new String[1];
        repository.newDiscount(discount, new ResultCallback()
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
    public String updateDiscount(Discount discount){
        final String[] r = new String[1];
        repository.updateDiscount(discount, new ResultCallback()
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
    public String removeOldDiscount(Discount discount){
        final String[] r = new String[1];
        repository.removeOldDiscount(discount, new ResultCallback()
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
    public String getBooking(Booking booking){
        final String[] r = new String[1];
        repository2.getBooking(booking, new ResultCallback()
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
    public String newRoute(Route route){
        final String[] r = new String[1];
        repository3.newRoute(route, new ResultCallback()
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
    public String updateRoute(Route route){
        final String[] r = new String[1];
        repository3.updateRoute(route, new ResultCallback()
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
    public String deleteRoute(Route route){
        final String[] r = new String[1];
        repository3.deleteRoute(route, new ResultCallback()
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