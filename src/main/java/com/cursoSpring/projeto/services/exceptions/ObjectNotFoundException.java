package com.cursoSpring.projeto.services.exceptions;

public class ObjectNotFoundException extends Exception {

  public ObjectNotFoundException(String msg) {
    super(msg);
  }

  public ObjectNotFoundException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
