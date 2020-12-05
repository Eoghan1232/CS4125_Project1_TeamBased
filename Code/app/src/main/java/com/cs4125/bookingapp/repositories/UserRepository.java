package com.cs4125.bookingapp.repositories;

import androidx.lifecycle.LiveData;

import com.cs4125.bookingapp.entities.User;

public interface UserRepository
{
    LiveData<String> loginUser(User user);
}
