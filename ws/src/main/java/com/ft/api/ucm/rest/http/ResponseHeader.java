package com.ft.api.ucm.rest.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A simple interface to a class representing an HttpServletResponse header
 *
 * @author andrew.winter
 */
public interface ResponseHeader {

  void setOn(HttpServletResponse response, HttpServletRequest request);
}
