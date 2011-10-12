package com.ft.unifiedContentModel.core.net;

import javax.servlet.http.HttpServletRequest;

public interface Request {

    HttpServletRequest getRequest();
    String getFormat();

}
