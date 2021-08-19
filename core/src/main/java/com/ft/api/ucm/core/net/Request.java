package com.ft.api.ucm.core.net;

import javax.servlet.http.HttpServletRequest;

public interface Request {

  HttpServletRequest getRequest();

  String getFormat();
}
