package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.entities.User;

public interface IUserService
{
    boolean registerNewUser(User user);
    boolean loginUser(User user);
    boolean modifyUser(User user);
}
