package edu.serjmaks.training_project.controller.impl;

import edu.serjmaks.training_project.controller.IntegrationTest;
import edu.serjmaks.training_project.dto.dog.DogLiteResponseDto;
import edu.serjmaks.training_project.dto.dog.DogResponseDto;
import edu.serjmaks.training_project.model.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DogControllerImplTest extends IntegrationTest {

    @Test
    void getAll() {
        Dog dog1 = new Dog();
        dog1.setName("fluffy");

        Dog dog2 = new Dog();
        dog2.setName("bobby");

        dog1 = dogRepository.save(dog1);
        dog2 = dogRepository.save(dog2);

        ResponseEntity<List<DogLiteResponseDto>> response = restTemplate.exchange(
                "/dog",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DogLiteResponseDto>>() {
                }
        );

        assertEquals(response.getStatusCode(), HttpStatus.OK);

        DogLiteResponseDto dogLiteResponseDto1 = new DogLiteResponseDto(dog1.getId(), dog1.getName());
        DogLiteResponseDto dogLiteResponseDto2 = new DogLiteResponseDto(dog2.getId(), dog2.getName());
        List<DogLiteResponseDto> actual = response.getBody();

        assertThat(actual).containsExactlyInAnyOrder(dogLiteResponseDto1, dogLiteResponseDto2);
    }
}