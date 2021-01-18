package com.schedulemaker.controllers;

import com.schedulemaker.auth.UserAuthenticationService;
import com.schedulemaker.entities.User;
import com.schedulemaker.services.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@CrossOrigin
@RestController
@RequestMapping("/public/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
final class PublicUsersController {
    @NonNull
    UserAuthenticationService authentication;
    @NonNull
    UserService users;

    @CrossOrigin
    @PostMapping("/register")
    String register(
            @RequestParam("username") final String username,
            @RequestParam("password") final String password) {
        users.createUser(
                User.builder()
                        .username(username)
                        .password(password)
                        .build()
        );

        return login(username, password);
    }

    @CrossOrigin
    @PostMapping("/login")
    String login(
            @RequestParam("username") final String username,
            @RequestParam("password") final String password) {
        return authentication
                .login(username, password)
                .orElseThrow(() -> new RuntimeException("Invalid login and/or password."));
    }
}
