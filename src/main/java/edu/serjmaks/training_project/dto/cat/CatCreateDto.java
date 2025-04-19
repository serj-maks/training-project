package edu.serjmaks.training_project.dto.cat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CatCreateDto(@NotBlank String name,
                           @NotNull int age) {
}
