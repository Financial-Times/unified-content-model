package com.ft.api.ucm.rest.filter;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

public class UserContextLoggingFilter extends CommonsRequestLoggingFilter {

  public static final String API_KEY_HEADER = "X-Api-Key";
  public static final String CONTENT_CONTROL_POLICY_HEADER = "X-FT-API-Content-Control-Policy";
  public static final String USER_IP_HEADER = "X-Forwarded-For";
  public static final String REQUEST_ID_HEADER = "X-Request-Id";

  protected static final String API_KEY_LABEL = "apiKey";
  protected static final String USER_IP_LABEL = "IP";
  protected static final String CONTENT_CONTROL_POLCIY_LABEL = "contentControlPolicy";
  protected static final String REQUEST_ID_LABEL = "requestId";

  @Override
  protected String createMessage(HttpServletRequest request, String prefix, String suffix) {
    StringBuilder msg = new StringBuilder();
    msg.append(prefix);
    appendCurrentLoggingContext(request, msg);
    msg.append(suffix);
    return msg.toString();
  }

  private void appendCurrentLoggingContext(HttpServletRequest request, StringBuilder appendTo) {
    String apikey = request.getHeader(API_KEY_HEADER);
    String ip = request.getHeader(USER_IP_HEADER);
    String contentControlPolicy = request.getHeader(CONTENT_CONTROL_POLICY_HEADER);
    String requestId = request.getHeader(REQUEST_ID_HEADER);

    if (!StringUtils.isBlank(apikey)) {
      appendTo.append(API_KEY_LABEL).append('=').append(apikey).append(' ');
    }

    appendTo
        .append(USER_IP_LABEL)
        .append('=')
        .append(StringUtils.isBlank(ip) ? request.getRemoteAddr() : ip)
        .append(' ');

    appendTo
        .append(CONTENT_CONTROL_POLCIY_LABEL)
        .append('=')
        .append(contentControlPolicy == null ? "" : contentControlPolicy)
        .append(' ');

    appendTo.append(REQUEST_ID_LABEL).append('=').append(requestId == null ? "" : requestId);
  }
}
