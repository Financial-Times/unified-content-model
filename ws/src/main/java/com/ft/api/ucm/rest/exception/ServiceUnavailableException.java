package com.ft.api.ucm.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnavailableException extends RuntimeException {

  public ServiceUnavailableException(Throwable cause) {
    super(cause);
  }
}
