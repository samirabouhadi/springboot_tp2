package com.example.tp2.Controller;

import com.example.tp2.Model.Task;
import com.example.tp2.Service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class taskController {
    private TaskService taskService;
    public taskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public List<Task> task() {
        return taskService.getTasks();
    }
    @PostMapping("/create")
    public Task addTask(@RequestBody Task task) {

        Task t=taskService.createTask(task);
        return t;
    }
    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable Long id,@RequestBody Task task) {
        return taskService.updateTask(id,task);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    }

