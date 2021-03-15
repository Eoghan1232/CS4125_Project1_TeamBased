package com.cs4125.bookingapp.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import com.cs4125.bookingapp.controllers.UserController;
import com.cs4125.bookingapp.model.UserFactory;
import com.cs4125.bookingapp.model.entities.User;
import com.cs4125.bookingapp.services.UserServiceImpl;
import com.cs4125.bookingapp.services.interceptor.FilterChain;
import com.cs4125.bookingapp.services.interceptor.FilterManager;
import com.cs4125.bookingapp.services.interceptor.LogFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserTest {

    @Mock
    private FilterManager myManager;
    @Mock
    private FilterChain filterChain;
    @Mock
    private LogFilter logFilter;
    @Mock
    private UserServiceImpl userServiceMock;
    @Mock
    private UserFactory userFactory;

    UserController userControllerMock;

    @Before
    public void init(){
        userControllerMock = new UserController(userServiceMock, myManager, logFilter);
    }

    @Test
    public void registerUserTest() {
    User mockUser = new User("Mock","password","mock@gmail.com",1);
    when(userFactory.getUser("NORMAL_USER","Mock","password","mock@gmail.com")).thenReturn(mockUser);
    when(userServiceMock.register(mockUser)).thenReturn("Success");
    String message = userControllerMock.addNewUser("Mock","password","mock@gmail.com");
    assertEquals("Success",message);
    }

    @Test
    public void LoginTest() {
        String mockUsername = "Dummy";
        String mockPassword = "testing";
        when(userServiceMock.login(mockUsername,mockPassword)).thenReturn("Success");
        String message = userControllerMock.getUser(mockUsername,mockPassword);
        assertEquals("Success", message);
    }

    @Test
    public void loginFailTest() {
        String mockUsername = "test";
        String mockPassword = "test";
        when(userServiceMock.login(mockUsername,mockPassword)).thenReturn("Failure");
        String message = userControllerMock.getUser(mockUsername,mockPassword);
        assertEquals("Failure", message);
    }

}
