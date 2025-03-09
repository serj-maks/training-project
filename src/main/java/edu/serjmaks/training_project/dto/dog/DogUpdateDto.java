package edu.serjmaks.training_project.dto.dog;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DogUpdateDto(@NotBlank String name,
                           @NotNull Integer age) {
}
