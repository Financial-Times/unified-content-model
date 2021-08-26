package com.ft.api.ucm.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RuntimeException {

  private static final long serialVersionUID = 4958319831736564447L;

  public UnprocessableEntityException() {
    super();
  }

  public UnprocessableEntityException(Throwable cause) {
    super(cause);
  }
}
