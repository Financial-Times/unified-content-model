package com.ft.api.ucm.core.net;

import javax.servlet.http.HttpServletRequest;

public class HttpProtocolResolver {

    private static final String HEADER_PROTOCOL_KEY = "X-Forwarded-Proto";

    public HttpProtocol getProtocol(HttpServletRequest httpServletRequest) {
        String parsedProtocol  = httpServletRequest.getHeader(HEADER_PROTOCOL_KEY);
        HttpProtocol httpProtocol = HttpProtocol.fromString(parsedProtocol);
        return httpProtocol == null ? HttpProtocol.HTTP : httpProtocol;
    }
}
