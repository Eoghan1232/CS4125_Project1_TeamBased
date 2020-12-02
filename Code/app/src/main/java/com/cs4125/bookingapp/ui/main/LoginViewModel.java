package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel
{
    // TODO: Implement the ViewModel
    private UserDoa repository;

    public void init(UserDoa repository){
        this.repository = repository;
    }

    public LiveData<ResponseBody> login(UserCredential credential){
        return repository.loginUser(credential);
    }

}