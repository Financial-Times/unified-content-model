package com.ft.api.ucm.rest.filter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserContextLoggingFilterTest {

  @Mock public HttpServletRequest request;
  public static final String prefix = "Hello";

  public static final String suffix = "Goodbye";
  public static final String apiKeyHeader = "tApiKeyHeader";
  public static final String userIpHeader = "theUserIpHeader";
  public static final String contentControlHeader = "theContentControlHeader";
  public static final String requestId = "theRequestId";

  public UserContextLoggingFilter userContextLoggingFilter;

  @Before
  public void setUp() {
    userContextLoggingFilter = new UserContextLoggingFilter();
  }

  @Test
  public void testCreateMessage() {

    when(request.getHeader(UserContextLoggingFilter.API_KEY_HEADER)).thenReturn(apiKeyHeader);
    when(request.getHeader(UserContextLoggingFilter.USER_IP_HEADER)).thenReturn(userIpHeader);
    when(request.getHeader(UserContextLoggingFilter.CONTENT_CONTROL_POLICY_HEADER))
        .thenReturn(contentControlHeader);
    when(request.getHeader(UserContextLoggingFilter.REQUEST_ID_HEADER)).thenReturn(requestId);
    String s = userContextLoggingFilter.createMessage(request, prefix, suffix);

    assertEquals(
        s,
        prefix
            + UserContextLoggingFilter.API_KEY_LABEL
            + "="
            + apiKeyHeader
            + " "
            + UserContextLoggingFilter.USER_IP_LABEL
            + "="
            + userIpHeader
            + " "
            + UserContextLoggingFilter.CONTENT_CONTROL_POLCIY_LABEL
            + "="
            + contentControlHeader
            + " "
            + UserContextLoggingFilter.REQUEST_ID_LABEL
            + "="
            + requestId
            + suffix);
  }
}
