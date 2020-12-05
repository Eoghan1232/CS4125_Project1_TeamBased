package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cs4125.bookingapp.entities.User;
import com.cs4125.bookingapp.repositories.UserRepository;

import okhttp3.ResponseBody;

public class LoginViewModel extends ViewModel
{
    // TODO: Implement the ViewModel
    private UserRepository repository;
    private LiveData<User> user;

    public void init(UserRepository repository){

        this.repository = repository;
    }

    public LiveData<ResponseBody> login(User user){
        return repository.loginUser(user);
    }

}