package edu.serjmaks.training_project.mapper;

import edu.serjmaks.training_project.dto.dog.DogCreateDto;
import edu.serjmaks.training_project.dto.dog.DogLiteResponseDto;
import edu.serjmaks.training_project.model.Dog;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DogMapperImplTest {

    DogMapper dogMapper = Mappers.getMapper(DogMapper.class);

    @Test
    void toDogLiteResponseDto() {
        Dog dog = new Dog();
        dog.setId(1);
        dog.setName("fluffy");

        DogLiteResponseDto dogLiteResponseDto = dogMapper.toDogLiteResponseDto(dog);

        assertEquals(dog.getId(), dogLiteResponseDto.id());
        assertEquals(dog.getName(), dogLiteResponseDto.name());
    }

    @Test
    void toDogsLiteResponseDto() {
        Dog dog = new Dog(1, "fluffy", 13);
        List<DogLiteResponseDto> actual = dogMapper.toDogsLiteResponseDto(List.of(dog));

        DogLiteResponseDto dogLiteResponseDto = new DogLiteResponseDto(1, "fluffy");
        List<DogLiteResponseDto> expected = List.of(dogLiteResponseDto);

        assertEquals(expected, actual);
    }

    @Test
    void toDog() {
        DogCreateDto dogCreateDto = new DogCreateDto("fluffy", 13);
        Dog dog = dogMapper.toDog(dogCreateDto);

        assertEquals(dog.getName(), dogCreateDto.name());
        assertEquals(dog.getAge(), dogCreateDto.age());
    }
}
