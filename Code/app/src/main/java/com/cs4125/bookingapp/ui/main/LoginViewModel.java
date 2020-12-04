package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.ViewModel;

import com.cs4125.bookingapp.repositories.UserRepository;

public class LoginViewModel extends ViewModel
{
    // TODO: Implement the ViewModel
    private UserRepository repository;

    public void init(UserRepository repository){
        this.repository = repository;
    }

//    public LiveData<ResponseBody> login(UserCredential credential){
//        return repository.loginUser(credential);
//    }

}