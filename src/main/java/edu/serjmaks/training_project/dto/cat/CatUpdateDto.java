package edu.serjmaks.training_project.dto.cat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CatUpdateDto(@NotBlank String name,
                           @NotNull int age) {
}
