package org.example3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//This class handles exceptions globally for all REST controllers
@RestControllerAdvice
public class GlobalExceptionHandler {

    //Handles all ResourceNotFoundExceptions thrown in the application
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        //Return 404 Not Found response with the appropriate exception message
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
