package edu.serjmaks.training_project.test.controller.impl;

import edu.serjmaks.training_project.test.controller.HumanController;
import edu.serjmaks.training_project.test.dto.human.HumanCreateDto;
import edu.serjmaks.training_project.test.dto.human.HumanLiteResponseDto;
import edu.serjmaks.training_project.test.dto.human.HumanResponseDto;
import edu.serjmaks.training_project.test.dto.human.HumanUpdateDto;
import edu.serjmaks.training_project.test.mapper.HumanMapper;
import edu.serjmaks.training_project.test.model.Human;
import edu.serjmaks.training_project.test.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HumanControllerImpl implements HumanController {

    private final HumanService humanService;
    private final HumanMapper humanMapper;

    @Override
    public HumanResponseDto getById(Long id) {
        Human human = humanService.getById(id);
        return humanMapper.toHumanResponseDto(human);
    }

    @Override
    public List<HumanLiteResponseDto> getAll() {
        List<Human> humans = humanService.getAll();
        return humanMapper.toHumanLiteResponseDto(humans);
    }

    @Override
    public HumanResponseDto create(HumanCreateDto dto) {
        Human human = humanMapper.toHuman(dto);
        Human createdHuman = humanService.create(human);
        return humanMapper.toHumanResponseDto(createdHuman);
    }

    @Override
    public HumanResponseDto update(HumanUpdateDto dto, Long id) {
        Human human = humanMapper.toHuman(dto);
        Human updatedHuman = humanService.update(human, id);
        return humanMapper.toHumanResponseDto(updatedHuman);
    }

    @Override
    public void deleteById(Long id) {
        humanService.deleteById(id);
    }
}
