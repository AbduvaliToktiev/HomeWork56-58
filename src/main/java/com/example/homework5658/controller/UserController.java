package com.example.homework5658.controller;

import com.example.homework5658.entity.User;
import com.example.homework5658.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/save-user")
    public String save(@RequestBody User user) {
        this.userService.save(user);
        return "SUCCESS!";
    }
}
