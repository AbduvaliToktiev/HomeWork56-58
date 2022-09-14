package com.example.homework5658.service;

import com.example.homework5658.dao.TaskRepository;
import com.example.homework5658.dao.UserRepository;
import com.example.homework5658.entity.Task;
import com.example.homework5658.entity.User;
import com.example.homework5658.enums.StatusTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Task> getAllTasks(String email, String password) {
        if (userRepository.authorizationUser(email, password) != null) {
            return this.taskRepository.getAllTasks(email, password);
        }
        return null;
    }

    public void save(String email, String password, Task task) {
        if (userRepository.authorizationUser(email, password) != null) {
            task.setStatusTask(StatusTask.NEW_TASK);
            this.taskRepository.save(task);
        }
    }

    public void changeStatus(String email, String password, Task task) {
        if (userRepository.authorizationUser(email, password) != null) {

            if (StatusTask.NEW_TASK.equals(task.getStatusTask())) {
                this.taskRepository.statusInProcess(String.valueOf(task.getUser().getId()));

            } else if (StatusTask.IN_PROCESS.equals(task.getStatusTask())) {
                this.taskRepository.statusDone(String.valueOf(task.getUser().getId()));
            }
        }
    }

    public List<Task> getAllByTaskId(String email, String password, Long taskId) {
        if (userRepository.authorizationUser(email, password) != null) {
            return this.taskRepository.findAllById(taskId);
        }
        return null;
    }
}
