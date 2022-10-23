package com.example.homework5658.service;

import com.example.homework5658.dao.UserRepository;
import com.example.homework5658.entity.Role;
import com.example.homework5658.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public void save(Users user) {
        this.userRepository.save(user);
    }

    public Users getById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userRepository.findFirstByEmail(email);

        if (users == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<Role> roleList = users.getRoles();

        for (Role role : roleList) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new User(users.getEmail(), users.getPassword(), authorities);
    }
}
