package edu.serjmaks.training_project.service.impl;

import edu.serjmaks.training_project.exception.AlreadyExistsException;
import edu.serjmaks.training_project.exception.NotFoundException;
import edu.serjmaks.training_project.model.Dog;
import edu.serjmaks.training_project.repository.DogRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DogServiceImplTest {

    @Mock
    private DogRepository dogRepositoryMock;

    @InjectMocks
    private DogServiceImpl dogService;

    @AfterEach
    void tearDown() {
        reset(dogRepositoryMock);
    }

    @Test
    void getById_returnDog() {
        int id = 1;
        Dog expected = new Dog("fluffy", 13);

        when(dogRepositoryMock.findById(id))
                .thenReturn(Optional.of(expected));
        Dog actual = dogService.getById(id);

        assertEquals(expected, actual);
        verify(dogRepositoryMock, times(1)).findById(id);
    }

    @Test
    void getById_throwException() {
        assertThrows(NotFoundException.class, () -> dogService.getById(Integer.MAX_VALUE));
    }

    @Test
    void save() {
        Dog expected = new Dog("fluffy", 13);

        when(dogRepositoryMock.save(expected))
                .thenReturn(expected);
        Dog actual = dogService.create(expected);

        assertEquals(expected, actual);
        verify(dogRepositoryMock).save(expected);
    }

    @Test
    void save_whenDogsHasEqualsName_throwException() {
        Dog dog = new Dog("fluffy", 13);

        when(dogRepositoryMock.existsByName(dog.getName()))
                .thenReturn(true);

        // здесь нужно использовать именно IllegalArgumentException, т.к. в методе
        // DogServiceImpl.create() используется конструкция с проверкой, где используется
        // IllegalArgumentException для срабатывания кода в классе exception/GlobalExceptionHandler
        assertThrows(IllegalArgumentException.class, () -> dogService.create(dog));
    }
}
