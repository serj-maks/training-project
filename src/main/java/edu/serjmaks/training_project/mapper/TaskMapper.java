package edu.serjmaks.training_project.mapper;

import edu.serjmaks.training_project.dto.task.TaskCreateDto;
import edu.serjmaks.training_project.dto.task.TaskLiteResponseDto;
import edu.serjmaks.training_project.dto.task.TaskResponseDto;
import edu.serjmaks.training_project.dto.task.TaskUpdateDto;
import edu.serjmaks.training_project.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface TaskMapper {

    TaskLiteResponseDto toTaskLiteResponseDto(Task task);

    List<TaskLiteResponseDto> toTasksLiteResponseDto(List<Task> tasks);

    Task toTask(TaskCreateDto dto);

    Task toTask(TaskUpdateDto dto);

    TaskResponseDto toTaskResponseDto(Task task);

    @Mapping(target = "id", ignore = true)
    void updateTask(Task newTask, @MappingTarget Task oldTask);
}
