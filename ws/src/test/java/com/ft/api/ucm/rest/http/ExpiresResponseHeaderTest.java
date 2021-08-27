package com.ft.api.ucm.rest.http;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.httpclient.util.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExpiresResponseHeaderTest {

  private ExpiresResponseHeader header;

  @Mock private HttpServletResponse mockResponse;
  @Mock private HttpServletRequest mockRequest;

  @BeforeEach
  public void setup() {
    header = new ExpiresResponseHeader();
  }

  @Test
  public void cacheControlSetOnResponse() {
    header.setOn(mockResponse, mockRequest);
    verify(mockResponse)
        .addHeader(eq(ExpiresResponseHeader.EXPIRES_HEADER_NAME), any(String.class));
  }

  @Test
  public void expiryDateIsInRFC1123Format() throws Exception {
    String returned = header.getExpiryDate();

    SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.PATTERN_RFC1123);
    Date date = sdf.parse(returned);
    assertThat(date, notNullValue());
  }
}
