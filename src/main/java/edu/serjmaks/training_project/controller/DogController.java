package edu.serjmaks.training_project.controller;

import edu.serjmaks.training_project.dto.dog.DogCreateDto;
import edu.serjmaks.training_project.dto.dog.DogLiteResponseDto;
import edu.serjmaks.training_project.dto.dog.DogResponseDto;
import edu.serjmaks.training_project.dto.dog.DogUpdateDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dog")
public interface DogController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<DogLiteResponseDto> getAll();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    DogResponseDto getById(@PathVariable("id") Integer id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    DogResponseDto create(@RequestBody @Valid DogCreateDto dto);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    DogResponseDto update(@RequestBody @Valid DogUpdateDto dto,
                          @PathVariable("id") Integer id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable("id") Integer id);
}
