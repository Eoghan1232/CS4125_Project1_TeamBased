package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cs4125.bookingapp.entities.Route;
import com.cs4125.bookingapp.repositories.BookingRepository;
import com.cs4125.bookingapp.repositories.ResultCallback;
import com.cs4125.bookingapp.repositories.RouteRepository;
import com.cs4125.bookingapp.repositories.RouteRepositoryImpl;
import com.cs4125.bookingapp.repositories.UserRepositoryImpl;

import okhttp3.Response;


public class SearchViewModel extends ViewModel {

    private RouteRepository repository;

    public void init() {
        this.repository = new RouteRepositoryImpl();
    }

    public String searchAll(Route search){
        final String[] r = new String[1];
        repository.searchAllRoute(search, new ResultCallback()
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
    public String searchRouteById(Route search){
        final String[] r = new String[1];
        repository.searchRouteById(search, new ResultCallback()
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

    public String searchRouteByStationOrDateTime(Route search){
        final String[] r = new String[1];
        repository.searchRouteByStationOrDateTime(search, new ResultCallback()
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
