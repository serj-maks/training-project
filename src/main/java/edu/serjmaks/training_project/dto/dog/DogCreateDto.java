package edu.serjmaks.training_project.dto.dog;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record DogCreateDto(@NotBlank String name,
                           @NotNull int age) {
}
