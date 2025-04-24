package edu.serjmaks.training_project.controller;

import edu.serjmaks.training_project.dto.task.TaskCreateDto;
import edu.serjmaks.training_project.dto.task.TaskLiteResponseDto;
import edu.serjmaks.training_project.dto.task.TaskResponseDto;
import edu.serjmaks.training_project.dto.task.TaskUpdateDto;
import edu.serjmaks.training_project.model.Task;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/tasks")
public interface TaskController {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    TaskResponseDto getById(@PathVariable("id") Integer id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<TaskLiteResponseDto> getAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    TaskResponseDto create(@RequestBody @Valid TaskCreateDto dto);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    TaskResponseDto update(@RequestBody @Valid TaskUpdateDto dto,
                           @PathVariable("id") Integer id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable("id") Integer id);
}
