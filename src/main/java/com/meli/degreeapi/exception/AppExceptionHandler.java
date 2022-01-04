package com.meli.degreeapi.exception;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        HttpStatus unprocessableEntity = HttpStatus.UNPROCESSABLE_ENTITY;

        for (FieldError field : ex.getBindingResult().getFieldErrors()) {
            errors.put(field.getField(), field.getDefaultMessage());
        }

        return new ResponseEntity<>(
                AppErrorResponse.builder()
                        .timestamp(Date.from(Instant.now()))
                        .code(unprocessableEntity.value())
                        .status(unprocessableEntity.name())
                        .message(ex.getMessage())
                        .data(errors)
                        .build(),
                unprocessableEntity);
    }

    @ExceptionHandler(SubjectInUseException.class)
    public ResponseEntity<AppErrorResponse> handleSubjectInUseException(SubjectInUseException ex) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(
                AppErrorResponse.builder()
                        .timestamp(Date.from(Instant.now()))
                        .code(badRequest.value())
                        .status(badRequest.name())
                        .message(ex.getMessage())
                        .build(),
                badRequest);
    }

    @ExceptionHandler(NoSuchElementFoundException.class)
    public ResponseEntity<AppErrorResponse> handleNoSuchElementFoundException(NoSuchElementFoundException ex) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(
                AppErrorResponse.builder()
                        .timestamp(Date.from(Instant.now()))
                        .code(notFound.value())
                        .status(notFound.name())
                        .message(ex.getMessage())
                        .build(),
                notFound);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppErrorResponse> handleException(Exception ex) {
        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;

        return new ResponseEntity<>(
                AppErrorResponse.builder()
                        .timestamp(Date.from(Instant.now()))
                        .code(internalServerError.value())
                        .status(internalServerError.name())
                        .message(ex.getMessage())
                        .build(),
                internalServerError);
    }
}
