package com.example.workintech.FruitsVegetables.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalErrorHandler {
    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException(FruitException exception) {
        FruitErrorResponse plantErrorResponse = new FruitErrorResponse(
                exception.getStatus().value(), exception.getMessage(), LocalDateTime.now()
        );
        return new ResponseEntity<>(plantErrorResponse, exception.getStatus());
    }
    @ExceptionHandler
    public ResponseEntity handleBindExceptions(MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> {
                    log.error(fieldError.getField() + ": " + fieldError.getDefaultMessage());
                    Map<String, String> errors = new HashMap<>();
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                    return errors;
                }).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorList);
    }
}
