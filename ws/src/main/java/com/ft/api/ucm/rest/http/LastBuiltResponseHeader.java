package com.ft.api.ucm.rest.http;

import com.ft.api.ucm.core.datetime.Clock;
import com.ft.api.ucm.core.datetime.SystemClock;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A ResponseHeader that configures a custom 'X-Last-Built' header to be added to the response,
 * specifying the time that content was fetched.
 */
public class LastBuiltResponseHeader implements ResponseHeader {

  static final String LAST_BUILT_HEADER_NAME = "X-Last-Built";

  private final Clock clock;

  public LastBuiltResponseHeader() {
    this.clock = new SystemClock();
  }

  public LastBuiltResponseHeader(Clock clock) {
    this.clock = clock;
  }

  @Override
  public void setOn(HttpServletResponse response, HttpServletRequest request) {
    response.addHeader(LAST_BUILT_HEADER_NAME, clock.toString());
  }
}
