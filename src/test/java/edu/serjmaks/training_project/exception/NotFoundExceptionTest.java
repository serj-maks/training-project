package edu.serjmaks.training_project.exception;

import edu.serjmaks.training_project.model.Dog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotFoundExceptionTest {

    @Test
    void notFoundException_messageCheck() {
        Dog dog = new Dog();
        dog.setName("fluffy");
        dog.setAge(13);

        NotFoundException exception = assertThrows(
                NotFoundException.class, () -> {
                    throw new NotFoundException(Dog.class, dog.getId());
                }
        );

        assertEquals("'Dog' with id: '" + dog.getId() + "' not found", exception.getMessage());
    }
}
