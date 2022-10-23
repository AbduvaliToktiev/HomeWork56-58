package com.example.homework5658.dao;

import com.example.homework5658.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findFirstByEmail(String email);
}
