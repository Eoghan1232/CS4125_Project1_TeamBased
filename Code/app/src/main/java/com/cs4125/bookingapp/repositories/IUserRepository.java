package com.cs4125.bookingapp.repositories;

import com.cs4125.bookingapp.entities.User;

public interface IUserRepository
{
    public boolean insertUser(User user);
    public boolean getUser(User user);
    public boolean updateUser(User user);
}
