package edu.serjmaks.training_project.controller.impl;

import edu.serjmaks.training_project.controller.TaskController;
import edu.serjmaks.training_project.dto.task.TaskCreateDto;
import edu.serjmaks.training_project.dto.task.TaskLiteResponseDto;
import edu.serjmaks.training_project.dto.task.TaskResponseDto;
import edu.serjmaks.training_project.dto.task.TaskUpdateDto;
import edu.serjmaks.training_project.mapper.TaskMapper;
import edu.serjmaks.training_project.model.Task;
import edu.serjmaks.training_project.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @Override
    public TaskResponseDto getById(Integer id) {
        Task task = taskService.getById(id);
        return taskMapper.toTaskResponseDto(task);
    }

    @Override
    public List<TaskLiteResponseDto> getAll() {
        List<Task> tasks = taskService.getAll();
        return taskMapper.toTasksLiteResponseDto(tasks);
    }

    @Override
    public TaskResponseDto create(TaskCreateDto dto) {
        Task task = taskMapper.toTask(dto);
        Task createdTas = taskService.create(task);
        return taskMapper.toTaskResponseDto(createdTas);
    }

    @Override
    public TaskResponseDto update(TaskUpdateDto dto, Integer id) {
        Task task = taskMapper.toTask(dto);
        Task updatedTask = taskService.update(task, id);
        return taskMapper.toTaskResponseDto(updatedTask);
    }

    @Override
    public void deleteById(Integer id) {
        taskService.deleteById(id);
    }
}
