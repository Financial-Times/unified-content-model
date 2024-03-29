package com.ft.api.ucm.rest.filter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.verify;

import com.ft.api.ucm.core.log.SupportLogger;
import com.ft.api.ucm.rest.filter.HttpErrorStatusLoggingFilter.HttpErrorStatusLoggingResponseWrapper;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.io.IOException;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.PassThroughFilterChain;

@ExtendWith(MockitoExtension.class)
public class HttpErrorStatusLoggingFilterTest {

  private static final int INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();
  private static final String INTERNAL_SERVER_ERROR_MSG = "500 Internal Server Error";
  private static final String REQUEST_URI = "/content/items/v1";
  private static final String QUERY_STRING = "query.queryString=test";
  private static final Map<String, String> REQUEST_HEADER_MAP;

  static {
    REQUEST_HEADER_MAP = Maps.newHashMap();
    REQUEST_HEADER_MAP.put(
        "Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    REQUEST_HEADER_MAP.put("Accept-Encoding", "gzip, deflate");
    REQUEST_HEADER_MAP.put("Accept-Language", "en-gb,en;q=0.5");
  }

  @Mock private HttpServletResponse mockResponse;
  @Mock private SupportLogger mocklog;

  private MockHttpServletRequest mockRequest;
  private MockFilterChain mockFilterChain;

  private HttpErrorStatusLoggingFilter instance;

  @BeforeEach
  public void setUp() throws Exception {
    instance = new HttpErrorStatusLoggingFilter(mocklog);
    mockFilterChain = new MockFilterChain();
    mockRequest = new MockHttpServletRequest();
  }

  @Test
  public void requestWrapped() throws Exception {
    instance.doFilter(mockRequest, mockResponse, mockFilterChain);
    assertThat(
        mockFilterChain.getResponse(), instanceOf(HttpErrorStatusLoggingResponseWrapper.class));
  }

  @Test
  public void logEventCreatedWhenSendingError() throws Exception {
    PassThroughFilterChain chain =
        new PassThroughFilterChain(
            instance, new PassThroughFilterChain(new ErrorSendingHttpServlet()));
    setupRequestData();
    instance.doFilter(mockRequest, mockResponse, chain);

    verify(mocklog).error(expectedLogMessage());
  }

  private void setupRequestData() {
    Map<String, String> requestHeaderMap = REQUEST_HEADER_MAP;
    for (Map.Entry<String, String> requestHeaderPair : requestHeaderMap.entrySet()) {
      mockRequest.addHeader(requestHeaderPair.getKey(), requestHeaderPair.getValue());
    }
    mockRequest.setRequestURI(REQUEST_URI);
    mockRequest.setQueryString(QUERY_STRING);
  }

  private String expectedLogMessage() {
    return new StringBuilder("[")
        .append("errorCode=")
        .append(INTERNAL_SERVER_ERROR)
        .append(", ")
        .append("errorMessage=")
        .append(INTERNAL_SERVER_ERROR_MSG)
        .append(", ")
        .append("url=")
        .append(REQUEST_URI)
        .append(", ")
        .append("queryString=")
        .append(QUERY_STRING)
        .append(", ")
        .append("IP=")
        .append(MockHttpServletRequest.DEFAULT_SERVER_ADDR)
        .append(", ")
        .append("headers=")
        .append(Multimaps.forMap(REQUEST_HEADER_MAP))
        .append("]")
        .toString();
  }

  private static class ErrorSendingHttpServlet implements Servlet {
    @Override
    public void service(ServletRequest req, ServletResponse res)
        throws ServletException, IOException {
      ((HttpServletResponse) res).sendError(INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MSG);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {}

    @Override
    public ServletConfig getServletConfig() {
      return null;
    }

    @Override
    public String getServletInfo() {
      return null;
    }

    @Override
    public void destroy() {}
  }
}
