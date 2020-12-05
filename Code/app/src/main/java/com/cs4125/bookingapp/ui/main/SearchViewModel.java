package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cs4125.bookingapp.repositories.BookingRepository;
import com.cs4125.bookingapp.repositories.RouteRepository;

import okhttp3.Response;
import okhttp3.Route;

public class SearchViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private RouteRepository repository;

    public void init(RouteRepository repository) {

        this.repository = repository;

    }

    public LiveData<Response> search(Route search){
        return repository.searchRoute(search);
    }
}