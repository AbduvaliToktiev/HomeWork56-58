package com.example.homework5658.controller;

import com.example.homework5658.entity.Users;
import com.example.homework5658.service.RoleService;
import com.example.homework5658.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration")
    public String save(@RequestBody Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(this.roleService.getRoleByName("USER"));
        this.userService.save(user);
        return "SUCCESS!";
    }
}
