package com.schedulemaker.services;

import com.schedulemaker.entities.User;
import com.schedulemaker.entities.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }
}
