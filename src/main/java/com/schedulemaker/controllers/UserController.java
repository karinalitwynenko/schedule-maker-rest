package com.schedulemaker.controllers;

import com.schedulemaker.entities.Schedule;
import com.schedulemaker.entities.User;
import com.schedulemaker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }
}
