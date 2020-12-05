package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cs4125.bookingapp.entities.User;
import com.cs4125.bookingapp.repositories.UserRepository;

import okhttp3.Response;

public class AdminViewModel extends ViewModel
{
    // TODO: Implement the ViewModel
    private UserRepository repository;

    public void init(UserRepository repository){
        this.repository = repository;
    }

    public LiveData<Response> admin(User admin){
//        return repository.adminUser(admin);
        return null;
    }
}