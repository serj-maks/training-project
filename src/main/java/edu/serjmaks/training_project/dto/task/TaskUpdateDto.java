package edu.serjmaks.training_project.dto.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskUpdateDto(@NotNull @NotBlank String title,
                            String description) {
}
