package edu.serjmaks.training_project.mapper;

import edu.serjmaks.training_project.dto.cat.CatCreateDto;
import edu.serjmaks.training_project.dto.cat.CatLiteResponseDto;
import edu.serjmaks.training_project.dto.cat.CatResponseDto;
import edu.serjmaks.training_project.dto.cat.CatUpdateDto;
import edu.serjmaks.training_project.model.Cat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface CatMapper {
    CatLiteResponseDto toCatLiteResponseDto(Cat cat);

    List<CatLiteResponseDto> toCatsLiteResponseDto(List<Cat> cats);

    Cat toCat(CatCreateDto dto);

    Cat toCat(CatUpdateDto dto);

    CatResponseDto toCatResponseDto(Cat cat);

    @Mapping(target = "id", ignore = true)
    Cat updateCat(Cat newCat, @MappingTarget Cat oldCat);
}
