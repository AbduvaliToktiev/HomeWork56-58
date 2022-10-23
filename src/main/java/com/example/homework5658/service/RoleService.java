package com.example.homework5658.service;

import com.example.homework5658.dao.RoleRepository;
import com.example.homework5658.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoleByName(String name) {
        return this.roleRepository.findAllByRole(name);
    }
}
