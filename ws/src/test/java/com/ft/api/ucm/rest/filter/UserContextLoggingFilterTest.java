package com.ft.api.ucm.rest.filter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserContextLoggingFilterTest {

  @Mock public HttpServletRequest request;
  public static final String prefix = "Hello";

  public static final String suffix = "Goodbye";
  public static final String apiKeyHeader = "tApiKeyHeader";
  public static final String userIpHeader = "theUserIpHeader";
  public static final String contentControlHeader = "theContentControlHeader";
  public static final String requestId = "theRequestId";

  public UserContextLoggingFilter userContextLoggingFilter;

  @BeforeEach
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

    assertThat(
        s,
        equalTo(
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
                + suffix));
  }
}
