package com.cs4125.bookingapp.repositories;

import androidx.lifecycle.LiveData;

import com.cs4125.bookingapp.entities.User;

public interface UserRepository
{
    void loginUser(User user, ResultCallback callback);

    void registerUser(User userRegister, ResultCallback resultCallback);
}
