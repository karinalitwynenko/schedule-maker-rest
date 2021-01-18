package com.schedulemaker.services;

import com.schedulemaker.entities.User;
import com.schedulemaker.entities.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return ofNullable(userRepository.findByUsername(username));
    }

    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }
}
