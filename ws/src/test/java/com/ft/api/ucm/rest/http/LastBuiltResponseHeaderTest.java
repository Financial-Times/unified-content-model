package com.ft.api.ucm.rest.http;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ft.api.ucm.core.datetime.Clock;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LastBuiltResponseHeaderTest {

  private static final String UTC_DATE = "2011-10-31T15:03:36.180Z";

  @Mock private HttpServletResponse mockResponse;
  @Mock private HttpServletRequest mockRequest;
  @Mock private Clock mockClock;

  private LastBuiltResponseHeader instance;

  @BeforeEach
  public void setUp() throws Exception {
    instance = new LastBuiltResponseHeader(mockClock);
  }

  @Test
  public void dateSetOnResponse() {
    when(mockClock.toString()).thenReturn(UTC_DATE);
    instance.setOn(mockResponse, mockRequest);
    verify(mockResponse).addHeader(LastBuiltResponseHeader.LAST_BUILT_HEADER_NAME, UTC_DATE);
  }
}
