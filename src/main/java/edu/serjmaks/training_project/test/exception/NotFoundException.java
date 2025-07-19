package edu.serjmaks.training_project.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(Class<?> entity, Object subject) {
        super(String.format("'%s' with field: '%s' not found", entity.getSimpleName(), subject));
    }
}
