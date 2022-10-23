package com.example.homework5658.dao;

import com.example.homework5658.entity.Task;
import com.example.homework5658.enums.StatusTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Modifying
    @Transactional
    @Query(value = "update tasks set status_task = :status_task where user_id = :user_id", nativeQuery = true)
    void statusChangeTask(@Param(value = "user_id") Long userId,
                         @Param(value = "status_task") String statusTask);


    List<Task> findAllById(Long taskId);
}
