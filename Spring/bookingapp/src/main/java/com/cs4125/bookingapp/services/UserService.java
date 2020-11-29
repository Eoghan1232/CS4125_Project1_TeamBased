package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String register(User u);
    String login(String name, String password);
}