package com.example.homework5658.dao;

import com.example.homework5658.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "select t.id, t.header, t.status_task, t.date_task  from tasks t " +
            "inner join users u on u.id = t.user_id " +
            "where u.email = :email and u.password = :password", nativeQuery = true)
    List<Task> getAllTasks(@Param(value = "email") String email,
                           @Param(value = "password") String password);


    @Query(value = "update tasks set status_task = 'IN_PROCESS' where user_id = :user_id", nativeQuery = true)
    Task statusInProcess(@Param(value = "user_id") String userId);

    @Query(value = "update tasks set status_task = 'DONE' where user_id = :user_id", nativeQuery = true)
    Task statusDone(@Param(value = "user_id") String userId);

    List<Task> findAllById(Long taskId);
}
