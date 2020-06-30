package com.example.demo.external.commons;

import com.example.demo.business.commons.validation.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.Optional;

@ControllerAdvice
public class RestResponseEntityExceptionHandler{
    private ResponseEntity<ErrorDto> buildErrorMsg(Exception exception, HttpStatus status){
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity <> (new ErrorDto(message,status.value()), status);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class,MethodArgumentTypeMismatchException.class})
    public ResponseEntity <ErrorDto> constraintViolation(final ConstraintViolationException exception) {
        return buildErrorMsg(exception,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity <ErrorDto> methodNotAllowed(final HttpRequestMethodNotSupportedException exception) {
        return buildErrorMsg(exception,HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity <ErrorDto> entityNotFound(final EntityNotFoundException exception) {
        return buildErrorMsg(exception,HttpStatus.NOT_FOUND);
    }
}