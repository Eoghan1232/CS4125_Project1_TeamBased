package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cs4125.bookingapp.entities.User;
import com.cs4125.bookingapp.repositories.UserRepository;

import okhttp3.ResponseBody;

public class RegisterViewModel extends ViewModel
{
    // TODO: Implement the ViewModel
    private UserRepository repository;

    public void init(UserRepository repository){

        this.repository = repository;
    }

    public LiveData<ResponseBody> register(User userRegister){
        return repository.registerUser(userRegister);
    }
}