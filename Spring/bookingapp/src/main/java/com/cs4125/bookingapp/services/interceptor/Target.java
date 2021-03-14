package com.cs4125.bookingapp.services.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface Target {

    public String execute(String request);

}
