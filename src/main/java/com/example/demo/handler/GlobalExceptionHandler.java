package com.example.demo.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;





import com.example.demo.exception.UserNotFoundException;
import com.example.demo.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex) {
    
    ErrorResponse message = new ErrorResponse(
      HttpStatus.NOT_FOUND.value(),
      ex.getMessage(),
      "error"

    );

    return new ResponseEntity<>(message , HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
      // 1. Recolectamos los errores detallados
      Map<String, String> fieldErrors = new HashMap<>();
      ex.getBindingResult().getFieldErrors().forEach(error -> {
          fieldErrors.put(error.getField(), error.getDefaultMessage());
      });

      // 2. Creamos la respuesta siguiendo TU estructura
      Map<String, Object> response = new HashMap<>();
      response.put("status", HttpStatus.BAD_REQUEST.value());
      response.put("message", "Error de validación en los campos enviados");
      response.put("data", fieldErrors); // Metemos los errores en el campo 'data' o creamos uno llamado 'errors'

      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }


}
