package edu.serjmaks.training_project.test.dto.human;

import edu.serjmaks.training_project.test.model.Task;

import java.util.List;

public record HumanResponseDto(Long id,
                               String name,
                               int age,
                               List<Task> tasks) {
}
