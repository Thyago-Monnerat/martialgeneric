package com.generic.MartialManager.exceptionsHandler;

import com.generic.MartialManager.exceptions.EventNotFoundException;
import com.generic.MartialManager.exceptions.InvalidNameFormatException;
import com.generic.MartialManager.exceptions.StudentNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> studentNotFoundException(StudentNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InvalidNameFormatException.class)
    public ResponseEntity<String> InvalidFormatNameException(InvalidNameFormatException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> DataIntegrityViolationException(DataIntegrityViolationException ex) {

        Throwable cause = ex.getCause();

        if (cause instanceof ConstraintViolationException constraintViolationException) {
            if (constraintViolationException.getSQLException() != null) {
                int errorCode = constraintViolationException
                        .getSQLException()
                        .getErrorCode();

                if (errorCode == 23505) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Falha ao tentar duplicar um valor único!");
                }
            }
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("Violação de dados. Verifique os campos informados.");
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<String> EventNotFoundException(EventNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> MethodArgumentTypeMismatchException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de dado inválido. Verifique sua requisição");
    }
}
