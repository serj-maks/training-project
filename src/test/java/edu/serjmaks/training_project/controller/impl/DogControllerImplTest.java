package edu.serjmaks.training_project.controller.impl;

import edu.serjmaks.training_project.IntegrationTest;
import edu.serjmaks.training_project.dto.dog.DogCreateDto;
import edu.serjmaks.training_project.dto.dog.DogLiteResponseDto;
import edu.serjmaks.training_project.dto.dog.DogResponseDto;
import edu.serjmaks.training_project.dto.dog.DogUpdateDto;
import edu.serjmaks.training_project.model.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Test
    void getById() {
        Dog dog = new Dog();
        dog.setName("fluffy");

        dog = dogRepository.save(dog);

        ResponseEntity<DogLiteResponseDto> response = restTemplate.exchange(
                "/dog/{id}",
                HttpMethod.GET,
                null,
                DogLiteResponseDto.class,
                Map.of("id", dog.getId())
        );

        assertEquals(response.getStatusCode(), HttpStatus.OK);

        DogLiteResponseDto expected = new DogLiteResponseDto(dog.getId(), dog.getName());
        DogLiteResponseDto actual = response.getBody();
        assertEquals(expected, actual);
    }

    @Test
    void getById_shouldReturn404Response() {
        ResponseEntity<DogLiteResponseDto> response = restTemplate.exchange(
                "/dog/{id}",
                HttpMethod.GET,
                null,
                DogLiteResponseDto.class,
                Map.of("id", Integer.MAX_VALUE)
        );

        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    void create() {
        ResponseEntity<DogLiteResponseDto> response = restTemplate.exchange(
                "/dog",
                HttpMethod.POST,
                new HttpEntity<>(new DogCreateDto("fluffy", 13)),
                DogLiteResponseDto.class
        );

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertTrue(dogRepository.existsById(Objects.requireNonNull(response.getBody()).id()));
    }

    @Test
    void update() {
        Dog dog = new Dog();
        dog.setName("fluffy");
        dog.setAge(13);

        dog = dogRepository.save(dog);

        ResponseEntity<DogLiteResponseDto> response = restTemplate.exchange(
                "/dog/{id}",
                HttpMethod.PUT,
                new HttpEntity<>(new DogUpdateDto("young flaffy", 3)),
                DogLiteResponseDto.class,
                Map.of("id", dog.getId())
        );

        assertEquals(response.getStatusCode(), HttpStatus.OK);

        DogLiteResponseDto expected = new DogLiteResponseDto(response.getBody().id(), response.getBody().name());
        DogLiteResponseDto actual = response.getBody();
        assertEquals(expected, actual);
    }

    @Test
    void deleteById() {
        Dog dog = new Dog();
        dog.setName("fluffy");
        dog.setAge(13);

        dog = dogRepository.save(dog);

        ResponseEntity<DogResponseDto> response = restTemplate.exchange(
                "/dog/{id}",
                HttpMethod.DELETE,
                null,
                DogResponseDto.class,
                Map.of("id", dog.getId())
        );

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertThat(dogRepository.findById(dog.getId())).isEmpty();
    }
}
