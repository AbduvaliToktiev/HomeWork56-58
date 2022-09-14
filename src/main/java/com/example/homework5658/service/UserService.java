package com.example.homework5658.service;

import com.example.homework5658.dao.UserRepository;
import com.example.homework5658.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        this.userRepository.save(user);
    }
}
