package edu.serjmaks.training_project.mapper;

import edu.serjmaks.training_project.dto.human.HumanCreateDto;
import edu.serjmaks.training_project.dto.human.HumanLiteResponseDto;
import edu.serjmaks.training_project.dto.human.HumanResponseDto;
import edu.serjmaks.training_project.dto.human.HumanUpdateDto;
import edu.serjmaks.training_project.model.Human;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface HumanMapper {

    HumanLiteResponseDto toHumanLiteResponseDto(Human human);

    List<HumanLiteResponseDto> toHumansLiteResponseDto(List<Human> humans);

    Human toHuman(HumanCreateDto dto);

    Human toHuman(HumanUpdateDto dto);

    HumanResponseDto toHumanResponseDto(Human human);

    @Mapping(target = "id", ignore = true)
    void updateHuman(Human newHuman, @MappingTarget Human oldHuman);
}
