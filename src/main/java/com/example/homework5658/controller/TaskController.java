package com.example.homework5658.controller;

import com.example.homework5658.entity.Task;
import com.example.homework5658.entity.Users;
import com.example.homework5658.enums.StatusTask;
import com.example.homework5658.service.TaskService;
import com.example.homework5658.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/get-all-task")
    public List<Task> getAll() {
        return this.taskService.getAllTasks();
    }

    @PostMapping(value = "/save-task")
    public String createNewTask(@RequestBody Task task,
                                @RequestParam(name = "userId") Long userId) {
        try {
            Users users = userService.getById(userId);
            task.setStatusTask(StatusTask.NEW_TASK);
            task.setUser(users);
            task.setDateTask(new Date());
            taskService.save(task);
            return "SUCCESS!";
        } catch (Exception e) {
            return "FAIL!";
        }
    }

    @PutMapping(value = "/change-status/{userId}/{statusTask}")
    public String changeTask(@PathVariable Long userId,
                             @PathVariable String statusTask) {
        taskService.changeStatus(userId, statusTask);
        return "SUCCESS!";
    }

    @GetMapping(value = "/get-all-by-task-id")
    public List<Task> getAllTaskById(@RequestParam(name = "taskId") Long taskId) {
        return this.taskService.getAllByTaskId(taskId);
    }
}
