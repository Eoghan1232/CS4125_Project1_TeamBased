package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.User;

public interface IUserService {
    String register(User u);
    String login(String username, String password);
}