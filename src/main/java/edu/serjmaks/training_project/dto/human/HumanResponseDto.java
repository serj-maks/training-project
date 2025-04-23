package edu.serjmaks.training_project.dto.human;

import edu.serjmaks.training_project.model.Task;

import java.util.List;

public record HumanResponseDto(Integer id,
                               String name,
                               int age,
                               List<Task> tasks) {
}
