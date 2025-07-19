package edu.serjmaks.training_project.dto.dog;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DogUpdateDtoTest {

    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void whenNotBlankName_thenNoConstraintViolation() {
        DogUpdateDto dogUpdateDto = new DogUpdateDto("Fluffy", 13);
        Set<ConstraintViolation<DogUpdateDto>> violations = validator.validate(dogUpdateDto);

        // разные варианты одной и той же проверки
//        assertEquals(violations.size(), 0);
//        assertThat(violations.size()).isEqualTo(0);
        assertTrue(violations.isEmpty());
    }

    @Test
    void whenBlankName_thenOneConstraintViolation() {
        DogUpdateDto dogUpdateDto = new DogUpdateDto(" ", 13);
        Set<ConstraintViolation<DogUpdateDto>> violations = validator.validateProperty(dogUpdateDto, "name");

        // разные варианты одной и той же проверки
//        assertEquals(violations.size(), 1);
//        assertThat(violations.size()).isNotZero();
        assertFalse(violations.isEmpty());
    }

    @Test
    void whenEmptyName_thenOneConstraintViolation() {
        DogUpdateDto dogUpdateDto = new DogUpdateDto("", 13);
        Set<ConstraintViolation<DogUpdateDto>> violations = validator.validateValue(DogUpdateDto.class, "name", "");

        // разные варианты одной и той же проверки
//        assertEquals(violations.size(), 1);
//        assertThat(violations).hasSize(1);
        assertFalse(violations.isEmpty());
    }

    @Test
    void whenNullName_thenOneConstraintViolation() {
        DogUpdateDto dogUpdateDto = new DogUpdateDto(null, 13);
        Set<ConstraintViolation<DogUpdateDto>> violations = validator.validate(dogUpdateDto);

        assertFalse(violations.isEmpty());
    }
}