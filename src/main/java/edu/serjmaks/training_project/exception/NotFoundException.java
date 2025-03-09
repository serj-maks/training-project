package edu.serjmaks.training_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(Class<?> entity, Integer id) {
        super(String.format("'%s' with id: '%s' not found", entity.getSimpleName(), id));
    }
}
