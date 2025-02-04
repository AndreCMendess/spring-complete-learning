package com.api.funcionario.api_funcionario.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;



public class ValidationHandler extends ResponseEntityExceptionHandler {


    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request){

        System.out.println("Entrou no manipulador de exceção para MethodArgumentNotValidException");
        logger.error("Entrou no manipulador de exceção para MethodArgumentNotValidException", ex);

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        System.out.println("Erros: " + errors);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
