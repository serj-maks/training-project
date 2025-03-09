package edu.serjmaks.training_project.mapper;

import edu.serjmaks.training_project.dto.dog.DogCreateDto;
import edu.serjmaks.training_project.dto.dog.DogLiteResponseDto;
import edu.serjmaks.training_project.dto.dog.DogResponseDto;
import edu.serjmaks.training_project.dto.dog.DogUpdateDto;
import edu.serjmaks.training_project.model.Dog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface DogMapper {
    DogLiteResponseDto toDogLiteResponseDto(Dog dog);

    List<DogLiteResponseDto> toDogsLiteResponseDto(List<Dog> tasks);

    Dog toDog(DogCreateDto dog);

    Dog toDog(DogUpdateDto dto);

    DogResponseDto toDogResponseDto(Dog dog);

    @Mapping(target = "id", ignore = true)
    void updateDog(Dog newDog, @MappingTarget Dog oldTask);
}
