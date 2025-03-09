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
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DogControllerImpl implements DogController {

    private final DogMapper dogMapper;
    private final DogServiceImpl dogService;

    //
    @Override
    public List<DogLiteResponseDto> getAll() {
        log.debug("getAll - start");

        List<Dog> dogs = dogService.getAll();
        List<DogLiteResponseDto> result = dogMapper.toDogsLiteResponseDto(dogs);

        log.debug("getAll - end: result = {}", result);
        return result;
    }

    @Override
    public DogResponseDto getById(Integer id) {
        log.debug("getById - start: id = {}", id);

        Dog dog = dogService.getById(id);
        DogResponseDto result = dogMapper.toDogResponseDto(dog);

        log.debug("getById - end: result = {}", result);
        return result;
    }

    @Override
    public DogResponseDto create(DogCreateDto dto) {
        log.debug("create - start");

        Dog dog = dogMapper.toDog(dto);
        Dog savedDog = dogService.create(dog);
        DogResponseDto result = dogMapper.toDogResponseDto(savedDog);

        log.debug("create - end: result = {}", result);
        return result;
    }

    @Override
    public DogResponseDto update(DogUpdateDto dto, Integer id) {
        log.debug("update - start: dto = {}", dto);

        Dog dog = dogMapper.toDog(dto);
        Dog savedDog = dogService.update(dog, id);
        DogResponseDto result = dogMapper.toDogResponseDto(savedDog);

        log.debug("update - end: result = {}", result);
        return result;
    }

    @Override
    public void deleteById(Integer id) {
        log.debug("deleteById - start: id = {}", id);

        dogService.deleteById(id);

        log.debug("deleteById - end");
    }
}
