package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
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

    public LiveData<String> searchAll(Route search){
        MutableLiveData<String> liveString = new MutableLiveData<>();
        repository.searchAllRoute(search, new ResultCallback()
        {
            @Override
            public void onResult(String result)
            {
                liveString.postValue(result);
            }

            @Override
            public void onFailure(Throwable error)
            {
                liveString.postValue(error.toString());
            }
        });
        return liveString;
    }
    public LiveData<String> searchRouteById(Route search){
        MutableLiveData<String> liveString = new MutableLiveData<>();
        repository.searchRouteById(search, new ResultCallback()
        {
            @Override
            public void onResult(String result)
            {
                liveString.postValue(result);
            }

            @Override
            public void onFailure(Throwable error)
            {
                liveString.postValue(error.toString());
            }
        });
        return liveString;
    }

    public LiveData<String> searchRouteByStationOrDateTime(Route search){
        MutableLiveData<String> liveString = new MutableLiveData<>();
        repository.searchRouteByStationOrDateTime(search, new ResultCallback()
        {
            @Override
            public void onResult(String result)
            {
                liveString.postValue(result);
            }

            @Override
            public void onFailure(Throwable error)
            {
                liveString.postValue(error.toString());
            }
        });
        return liveString;
    }

}
