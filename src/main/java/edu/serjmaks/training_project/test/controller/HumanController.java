package edu.serjmaks.training_project.test.controller;

import edu.serjmaks.training_project.test.dto.human.HumanCreateDto;
import edu.serjmaks.training_project.test.dto.human.HumanLiteResponseDto;
import edu.serjmaks.training_project.test.dto.human.HumanResponseDto;
import edu.serjmaks.training_project.test.dto.human.HumanUpdateDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/humans")
public interface HumanController {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    HumanResponseDto getById(@PathVariable("id") Long id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<HumanLiteResponseDto> getAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    HumanResponseDto create(@RequestBody @Valid HumanCreateDto human);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    HumanResponseDto update(@RequestBody @Valid HumanUpdateDto human,
                            @PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable("id") Long id);
}
