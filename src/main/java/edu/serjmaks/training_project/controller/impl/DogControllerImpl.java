package edu.serjmaks.training_project.controller.impl;

import edu.serjmaks.training_project.controller.DogController;
import edu.serjmaks.training_project.dto.dog.DogCreateDto;
import edu.serjmaks.training_project.dto.dog.DogLiteResponseDto;
import edu.serjmaks.training_project.dto.dog.DogResponseDto;
import edu.serjmaks.training_project.dto.dog.DogUpdateDto;
import edu.serjmaks.training_project.mapper.DogMapper;
import edu.serjmaks.training_project.model.Dog;
import edu.serjmaks.training_project.service.impl.DogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DogControllerImpl implements DogController {

    private final DogMapper dogMapper;
    private final DogServiceImpl dogService;

    @Override
    public List<DogLiteResponseDto> getAll() {
        List<Dog> dogs = dogService.getAll();
        List<DogLiteResponseDto> result = dogMapper.toDogsLiteResponseDto(dogs);
        return result;
    }

    @Override
    public DogResponseDto getById(Integer id) {
        Dog dog = dogService.getById(id);
        DogResponseDto result = dogMapper.toDogResponseDto(dog);
        return result;
    }

    @Override
    public DogResponseDto create(DogCreateDto dto) {
        Dog dog = dogMapper.toDog(dto);
        Dog savedDog = dogService.create(dog);
        DogResponseDto result = dogMapper.toDogResponseDto(savedDog);
        return result;
    }

    @Override
    public DogResponseDto update(DogUpdateDto dto, Integer id) {
        Dog dog = dogMapper.toDog(dto);
        Dog savedDog = dogService.update(dog, id);
        DogResponseDto result = dogMapper.toDogResponseDto(savedDog);
        return result;
    }

    @Override
    public void deleteById(Integer id) {
        dogService.deleteById(id);
    }
}
