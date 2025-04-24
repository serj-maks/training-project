package edu.serjmaks.training_project.service;

import edu.serjmaks.training_project.model.Task;

import java.util.List;

public interface TaskService {
    Task getById(Integer id);
    List<Task> getAll();
    Task create(Task task);
    Task update(Task task, Integer id);
    void deleteById(Integer id);
}
