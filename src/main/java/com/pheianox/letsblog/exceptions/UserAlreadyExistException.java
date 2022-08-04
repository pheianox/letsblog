package com.pheianox.letsblog.exceptions;

public class UserAlreadyExistException extends Exception {
  public UserAlreadyExistException(String message) {
    super(message);
  }
}
