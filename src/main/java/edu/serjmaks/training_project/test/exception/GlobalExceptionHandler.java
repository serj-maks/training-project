package edu.serjmaks.training_project.test.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFoundException(NotFoundException e,
                                                                       HttpServletRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp: ", LocalDateTime.now());
        body.put("error: ", "Not Found");
        body.put("message: ", e.getMessage());
        body.put("path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleAlreadyExistsException(AlreadyExistsException e,
                                                                            HttpServletRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp: ", LocalDateTime.now());
        body.put("error: ", "Already Exists");
        body.put("message", e.getMessage());
        body.put("path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
