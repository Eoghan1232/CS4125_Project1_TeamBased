package com.cs4125.bookingapp.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.cs4125.bookingapp.controllers.UserController;
import com.cs4125.bookingapp.model.ConcreteUserFactory;
import com.cs4125.bookingapp.model.UserFactory;
import com.cs4125.bookingapp.model.entities.User;
import com.cs4125.bookingapp.model.repositories.LogRepository;
import com.cs4125.bookingapp.model.repositories.UserRepository;
import com.cs4125.bookingapp.services.UserServiceImpl;
import com.cs4125.bookingapp.services.interceptor.FilterManager;
import com.cs4125.bookingapp.services.interceptor.LogFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

//This creates a DB in memory so it doesn't affect the real DB.
@DataJpaTest
public class UserControllerTests {

    private FilterManager myManager;
    private LogFilter logFilter;
    private UserServiceImpl userServiceMock;
    private UserController userControllerMock;
    private UserFactory userFactory;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LogRepository logRepository;

    @BeforeEach
    public void init(){
        myManager = new FilterManager();
        logFilter = new LogFilter(logRepository);
        userFactory = new ConcreteUserFactory();
        userServiceMock = new UserServiceImpl(userRepository, new ConcreteUserFactory());
        userControllerMock = new UserController(userServiceMock,myManager,logFilter);
    }

    //Test the 4 Controllers in separate files.

    @Test
    public void registerUserTest() {
    String message = userControllerMock.addNewUser("Mock","password","mock@gmail.com");
    assertEquals("SUCCESS",message.split(":")[0]);
    }

    @Test
    public void loginFailTest() {
        String mockUsername = "MOCKUSERNAMETHATNOONEWILLEVERGET";
        String mockPassword = "RANDOMPASSWORDTHATNOONEWILLEVERGET";
        String message = userControllerMock.getUser(mockUsername,mockPassword);
        assertEquals("FAILURE", message.split(":")[0]);
    }

    @Test
    public void LoginTest() { ;
        userControllerMock.addNewUser("dummy","testing","dummytesting@gmail.com");
        String mockUsername = "dummy";
        String mockPassword = "testing";
        String message = userControllerMock.getUser(mockUsername,mockPassword);
        assertEquals("SUCCESS", message.split(":")[0]);
    }

}
