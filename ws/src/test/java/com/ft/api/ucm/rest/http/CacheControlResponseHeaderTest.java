package com.ft.api.ucm.rest.http;

import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CacheControlResponseHeaderTest {

  private CacheControlResponseHeader header;

  @Mock private HttpServletResponse mockResponse;
  @Mock private HttpServletRequest mockRequest;

  @BeforeEach
  public void setup() {
    header = new CacheControlResponseHeader();
  }

  @Test
  public void cacheControlSetOnResponse() {
    header.setOn(mockResponse, mockRequest);
    verify(mockResponse)
        .addHeader(
            CacheControlResponseHeader.CACHE_CONTROL_HEADER_NAME,
            CacheControlResponseHeader.CACHE_CONTROL_HEDAER_VALUE);
  }
}
