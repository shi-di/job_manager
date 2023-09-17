package com.example.job_manager_service.application_exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(NotFoundUnapprovedJobException.class)
    public ResponseEntity<?> httpClientErrorExceptionHandler(NotFoundUnapprovedJobException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getExceptionMessage());
    }

    @ExceptionHandler(NotFoundPasswordAndIdException.class)
    public ResponseEntity<?> httpClientErrorExceptionHandler(NotFoundPasswordAndIdException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getExceptionMessage());
    }
}
