package com.cs4125.bookingapp.model;

import com.cs4125.bookingapp.model.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserFactory {
    User getUser(String userType, String username, String password, String email);
}
