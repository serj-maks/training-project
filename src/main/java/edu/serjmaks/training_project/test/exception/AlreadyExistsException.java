package edu.serjmaks.training_project.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(Class<?> entity, Object subject) {
        super(String.format("'%s' with field: '%s' already exists", entity.getSimpleName(), subject));
    }
}
