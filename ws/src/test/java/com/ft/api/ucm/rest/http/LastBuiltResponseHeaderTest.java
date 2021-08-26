package com.ft.api.ucm.rest.http;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ft.api.ucm.core.datetime.Clock;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LastBuiltResponseHeaderTest {

  private static final String UTC_DATE = "2011-10-31T15:03:36.180Z";

  @Mock private HttpServletResponse mockResponse;
  @Mock private HttpServletRequest mockRequest;
  @Mock private Clock mockClock;

  private LastBuiltResponseHeader instance;

  @Before
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
