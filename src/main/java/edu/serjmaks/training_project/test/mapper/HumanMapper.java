package edu.serjmaks.training_project.test.mapper;

import edu.serjmaks.training_project.test.dto.human.HumanCreateDto;
import edu.serjmaks.training_project.test.dto.human.HumanLiteResponseDto;
import edu.serjmaks.training_project.test.dto.human.HumanResponseDto;
import edu.serjmaks.training_project.test.dto.human.HumanUpdateDto;
import edu.serjmaks.training_project.test.model.Human;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface HumanMapper {

    HumanResponseDto toHumanResponseDto(Human human);

    List<HumanLiteResponseDto> toHumanLiteResponseDto(List<Human> humans);

    Human toHuman(HumanCreateDto dto);

    Human toHuman(HumanUpdateDto dto);

    @Mapping(target = "id", ignore = true)
    Human update(Human newHuman, @MappingTarget Human oldHuman);

}
