package com.example.homework5658.dao;

import com.example.homework5658.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users where email = :email and password = :password", nativeQuery = true)
    User authorizationUser(@Param(value = "email")String email,
                           @Param(value = "password")String password);
}
