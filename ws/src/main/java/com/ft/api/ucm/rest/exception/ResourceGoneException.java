package com.ft.api.ucm.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.GONE)
public class ResourceGoneException extends RuntimeException {

  private static final long serialVersionUID = -7022986960748168122L;

  public ResourceGoneException(Throwable cause) {
    super(cause);
  }
}
