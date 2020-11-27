package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.model.IUserFactory;
import com.cs4125.bookingapp.model.UserFactory;
import com.cs4125.bookingapp.model.entities.User;
import com.cs4125.bookingapp.services.IUserService;
import com.cs4125.bookingapp.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private IUserService userService = new UserService();
    private IUserFactory userFactory = new UserFactory();

    @GetMapping("/loginuser")
    @ResponseBody
    public String getUser(@RequestParam String name, @RequestParam String password) {
        String result = userService.login(name, password);

        return result;
    }

    @PostMapping(path="/registeruser")
    @ResponseBody
    public String addNewUser (@RequestParam String name, @RequestParam String password, @RequestParam String email) {
        User u = userFactory.getUser("NORMAL_USER", name, password, email);
        String result = userService.register(u);

        return result;
    }
}
