package com.example.tp2.Service;

import com.example.tp2.Model.Task;
import com.example.tp2.Repository.taskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {
    private taskRepository repo;
    public TaskService(taskRepository repo) {
        this.repo = repo;
    }
  public Task createTask(Task task) {
        repo.save(task);
       return task;
    }

    public List<Task> getTasks() {
   List<Task> results=  repo.findAll();
   return results;
    }
    public Task getTaskById(Long id) {
        return repo.findById(id).orElse(null);
    }
   public Task updateTask(Long id,Task updatedTask) {
        if(repo.existsById(id)){
            updatedTask.setId(id);
           return repo.save(updatedTask);
        }
        return null;
   }
    public void deleteTaskById(Long id) {
        repo.deleteById(id);
    }

}
