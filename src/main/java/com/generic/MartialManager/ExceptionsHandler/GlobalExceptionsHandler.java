package com.generic.MartialManager.ExceptionsHandler;

import com.generic.MartialManager.Exceptions.InvalidNameFormatException;
import com.generic.MartialManager.Exceptions.StudentNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> studentNotFoundException(StudentNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> HttpMessageNotReadableException(HttpMessageNotReadableException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InvalidNameFormatException.class)
    public ResponseEntity<String> InvalidFormatNameException(InvalidNameFormatException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> DataIntegrityViolationException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Violação de dados. Verifique os campos informados.");
    }
}
