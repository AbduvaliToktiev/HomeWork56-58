package com.example.homework5658.service;

import com.example.homework5658.dao.TaskRepository;
import com.example.homework5658.dao.UserRepository;
import com.example.homework5658.entity.Task;
import com.example.homework5658.enums.StatusTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return this.taskRepository.findAll();
    }

    public void save(Task task) {
        task.setStatusTask(StatusTask.NEW_TASK);
        this.taskRepository.save(task);
    }

    public void changeStatus(Long userId, String statusTask) {
        this.taskRepository.statusChangeTask(userId, statusTask);
    }

    public List<Task> getAllByTaskId(Long taskId) {
        return this.taskRepository.findAllById(taskId);
    }
}
