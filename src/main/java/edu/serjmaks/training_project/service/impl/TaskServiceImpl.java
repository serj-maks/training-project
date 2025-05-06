package edu.serjmaks.training_project.service.impl;

import edu.serjmaks.training_project.exception.AlreadyExistsException;
import edu.serjmaks.training_project.exception.NotFoundException;
import edu.serjmaks.training_project.mapper.TaskMapper;
import edu.serjmaks.training_project.model.Task;
import edu.serjmaks.training_project.repository.TaskRepository;
import edu.serjmaks.training_project.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public Task getById(Integer id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Task.class, id));
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Transactional
    @Override
    public Task create(Task task) {
        if (taskRepository.existsByTitle(task.getTitle())) {
            throw new AlreadyExistsException(Task.class, task.getTitle());
        }
        return taskRepository.save(task);
    }

    @Transactional
    @Override
    @Retryable(maxAttempts = 15)
    public Task update(Task newTask, Integer id) {
        Task task = getById(id);
        taskMapper.updateTask(newTask, task);
        return taskRepository.save(task);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        if (!taskRepository.existsById(id)) {
            throw new NotFoundException(Task.class, id);
        }
        taskRepository.deleteById(id);
    }
}
