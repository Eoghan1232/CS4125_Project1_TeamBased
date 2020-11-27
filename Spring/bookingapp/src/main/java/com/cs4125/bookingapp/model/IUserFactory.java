package com.cs4125.bookingapp.model;

import com.cs4125.bookingapp.model.entities.User;

public interface IUserFactory {
    User getUser(String userType, String username, String password, String email);
}
