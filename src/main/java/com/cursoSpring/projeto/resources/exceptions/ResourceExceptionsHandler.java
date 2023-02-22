package com.cursoSpring.projeto.resources.exceptions;

import com.cursoSpring.projeto.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ResourceExceptionsHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> ObjectNotFound(
    ObjectNotFoundException e,
    HttpServletRequest request
  ) {
    StandardError error = new StandardError(
      HttpStatus.BAD_REQUEST.value(),
      e.getMessage(),
      System.currentTimeMillis()
    );

    return ResponseEntity.badRequest().body(error);
  }
}
