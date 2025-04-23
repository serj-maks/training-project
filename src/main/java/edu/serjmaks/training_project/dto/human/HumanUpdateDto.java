package edu.serjmaks.training_project.dto.human;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HumanUpdateDto(@NotBlank String name,
                             @NotNull int age) {
}
