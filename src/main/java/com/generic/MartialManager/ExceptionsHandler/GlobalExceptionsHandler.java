package com.generic.MartialManager.ExceptionsHandler;

import com.generic.MartialManager.Exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> studentNotFoundException(StudentNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> NumberFormatException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formato do campo inválido!");
    }

}
