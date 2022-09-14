package com.example.homework5658.controller;

import com.example.homework5658.entity.Task;
import com.example.homework5658.entity.User;
import com.example.homework5658.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/task")
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/get-all-task")
    public List<Task> getAll(@RequestParam(value = "email") String email,
                             @RequestParam(value = "password") String password) {
        return this.taskService.getAllTasks(email, password);
    }

    @PostMapping(value = "/save-task")
    public String createNewTask(@RequestBody Task task,
                                @RequestParam(value = "email") String email,
                                @RequestParam(value = "password") String password) {
        taskService.save(email, password, task);
        return "SUCCESS!";
    }

    @PutMapping(value = "/change-status")
    public String changeTask(@RequestBody Task task,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "password") String password) {
        taskService.changeStatus(email, password, task);
        return "SUCCESS!";
    }

    @GetMapping(value = "/get-all-by-task")
    public List<Task> getAllTaskById(@RequestParam(name = "email") String email,
                                     @RequestParam(name = "password") String password,
                                     @RequestParam(name = "taskId") Long taskId) {
        return this.taskService.getAllByTaskId(email, password, taskId);
    }
}
