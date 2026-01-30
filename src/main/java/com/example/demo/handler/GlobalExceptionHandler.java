package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


}
