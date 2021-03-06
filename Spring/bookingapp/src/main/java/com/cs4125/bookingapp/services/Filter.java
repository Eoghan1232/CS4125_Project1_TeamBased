package com.cs4125.bookingapp.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface Filter {

    public void execute(String request);

}
