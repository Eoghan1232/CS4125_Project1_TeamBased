package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.model.UserFactory;
import com.cs4125.bookingapp.model.entities.User;
import com.cs4125.bookingapp.services.LogFilter;
import com.cs4125.bookingapp.services.Target;
import com.cs4125.bookingapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private FilterManager myManager;
    @Autowired
    private LogFilter logFilter;

    public void instantiateManager(){
        myManager.setFilter(logFilter);
        myManager.setTarget((Target) userService);
    }

    @GetMapping(path="/loginuser")
    @ResponseBody
    public String getUser(@RequestParam String name, @RequestParam String password) {
        instantiateManager();
        String request = "login," + name + "," + password;
        return myManager.filterRequest(request);
//        String result = userService.login(name, password);
//        return result;
    }

    @PostMapping(path="/registeruser")
    @ResponseBody
    public String addNewUser (@RequestParam String name, @RequestParam String password, @RequestParam String email) {
        instantiateManager();
        String request = "register," + name + "," + password + "," + email;
//        User u = userFactory.getUser("NORMAL_USER", name, password, email);
//        String result = userService.register(u);
        return myManager.filterRequest(request);
    }
}