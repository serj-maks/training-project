package edu.serjmaks.training_project.dto.task;

import edu.serjmaks.training_project.model.Human;

import java.util.List;

public record TaskResponseDto(Integer id,
                              String title,
                              String description,
                              List<Human> humans) {
}
