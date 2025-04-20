package edu.serjmaks.training_project.controller.impl;

import edu.serjmaks.training_project.controller.CatController;
import edu.serjmaks.training_project.dto.cat.CatCreateDto;
import edu.serjmaks.training_project.dto.cat.CatLiteResponseDto;
import edu.serjmaks.training_project.dto.cat.CatResponseDto;
import edu.serjmaks.training_project.dto.cat.CatUpdateDto;
import edu.serjmaks.training_project.mapper.CatMapper;
import edu.serjmaks.training_project.model.Cat;
import edu.serjmaks.training_project.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CatControllerImpl implements CatController {

    private final CatService catService;
    private final CatMapper catMapper;

    @Override
    public List<CatLiteResponseDto> getAll() {
        List<Cat> cats = catService.getAll();
        return catMapper.toCatsLiteResponseDto(cats);
    }

    @Override
    public CatResponseDto getById(Integer id) {
        Cat cat = catService.getById(id);
        return catMapper.toCatResponseDto(cat);
    }

    @Override
    public CatResponseDto create(CatCreateDto dto) {
        Cat cat = catMapper.toCat(dto);
        Cat createdCat = catService.create(cat);
        return catMapper.toCatResponseDto(createdCat);
    }

    @Override
    public CatResponseDto update(CatUpdateDto dto, Integer id) {
        Cat cat = catMapper.toCat(dto);
        Cat updatedCat = catService.update(cat, id);
        return catMapper.toCatResponseDto(updatedCat);
    }

    @Override
    public void deleteById(Integer id) {
        catService.deleteById(id);
    }
}
