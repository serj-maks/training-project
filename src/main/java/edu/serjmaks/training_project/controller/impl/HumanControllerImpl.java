package edu.serjmaks.training_project.controller.impl;

import edu.serjmaks.training_project.controller.HumanController;
import edu.serjmaks.training_project.dto.human.HumanCreateDto;
import edu.serjmaks.training_project.dto.human.HumanLiteResponseDto;
import edu.serjmaks.training_project.dto.human.HumanResponseDto;
import edu.serjmaks.training_project.dto.human.HumanUpdateDto;
import edu.serjmaks.training_project.mapper.HumanMapper;
import edu.serjmaks.training_project.model.Human;
import edu.serjmaks.training_project.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HumanControllerImpl implements HumanController {

    private final HumanService humanService;
    private final HumanMapper humanMapper;

    @Override
    public HumanResponseDto getById(Integer id) {
        Human human = humanService.getById(id);
        return humanMapper.toHumanResponseDto(human);
    }

    @Override
    public List<HumanLiteResponseDto> getAll() {
        List<Human> humans = humanService.getAll();
        return humanMapper.toHumansLiteResponseDto(humans);
    }

    @Override
    public HumanResponseDto create(HumanCreateDto dto) {
        Human human = humanMapper.toHuman(dto);
        Human createdHuman = humanService.create(human);
        return humanMapper.toHumanResponseDto(createdHuman);
    }

    @Override
    public HumanResponseDto update(HumanUpdateDto dto, Integer id) {
        Human human = humanMapper.toHuman(dto);
        Human updatedHuman = humanService.update(human, id);
        return humanMapper.toHumanResponseDto(updatedHuman);
    }

    @Override
    public void deleteById(Integer id) {
         humanService.deleteById(id);
    }
}
