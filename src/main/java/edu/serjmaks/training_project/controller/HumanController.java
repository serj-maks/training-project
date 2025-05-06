package edu.serjmaks.training_project.controller;

import edu.serjmaks.training_project.dto.human.HumanCreateDto;
import edu.serjmaks.training_project.dto.human.HumanLiteResponseDto;
import edu.serjmaks.training_project.dto.human.HumanResponseDto;
import edu.serjmaks.training_project.dto.human.HumanUpdateDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/humans")
public interface HumanController {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    HumanResponseDto getById(@PathVariable("id") Integer id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<HumanLiteResponseDto> getAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    HumanResponseDto create(@RequestBody @Valid HumanCreateDto dto);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    HumanResponseDto update(@RequestBody @Valid HumanUpdateDto dto,
                            @PathVariable("id") Integer id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable("id") Integer id);
}
