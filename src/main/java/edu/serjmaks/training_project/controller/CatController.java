package edu.serjmaks.training_project.controller;

import edu.serjmaks.training_project.dto.cat.CatCreateDto;
import edu.serjmaks.training_project.dto.cat.CatLiteResponseDto;
import edu.serjmaks.training_project.dto.cat.CatResponseDto;
import edu.serjmaks.training_project.dto.cat.CatUpdateDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cat")
public interface CatController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<CatLiteResponseDto> getAll();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CatResponseDto getById(@PathVariable Integer id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CatResponseDto create(@RequestBody @Valid CatCreateDto dto);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CatResponseDto update(@RequestBody @Valid CatUpdateDto dto,
                          @PathVariable Integer id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable Integer id);
}
