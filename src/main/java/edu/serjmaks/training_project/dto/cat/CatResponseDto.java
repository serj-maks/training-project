package edu.serjmaks.training_project.dto.cat;

public record CatResponseDto(Integer id,
                             String name,
                             //TODO: если будет ошибка - исправить на объект
                             int age) {
}
