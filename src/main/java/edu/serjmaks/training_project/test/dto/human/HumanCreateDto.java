package edu.serjmaks.training_project.test.dto.human;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HumanCreateDto(@NotBlank String name,
                             @Min(0) @Max(99) @NotNull int age) {
}
