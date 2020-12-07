package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cs4125.bookingapp.entities.User;
import com.cs4125.bookingapp.repositories.BookingRepositoryImpl;
import com.cs4125.bookingapp.repositories.ResultCallback;
import com.cs4125.bookingapp.repositories.UserRepository;
import com.cs4125.bookingapp.repositories.UserRepositoryImpl;

import okhttp3.ResponseBody;

public class LoginViewModel extends ViewModel
{
    private UserRepository repository;

    public void init(){
        this.repository = new UserRepositoryImpl();
    }

    public String login(User user){
        final String[] r = new String[1];
        repository.loginUser(user, new ResultCallback()
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