package com.ft.api.ucm.rest.filter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.ft.api.ucm.rest.http.ResponseHeader;
import com.google.common.collect.Lists;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ResponseHeaderSettingFilterTest {

  @Mock private HttpServletRequest mockRequest;
  @Mock private HttpServletResponse mockResponse;
  @Mock private FilterChain mockFilterChain;
  @Mock private ResponseHeader mockResponseHeader;

  private ResponseHeaderSettingFilter instance;

  @BeforeEach
  public void setUp() throws Exception {
    instance = new ResponseHeaderSettingFilter(Lists.newArrayList(mockResponseHeader));
  }

  @Test
  public void headersAddedToResponseAndChainInvoked() throws Exception {
    instance.doFilterInternal(mockRequest, mockResponse, mockFilterChain);
    verify(mockResponseHeader).setOn(any(HttpServletResponse.class), any(HttpServletRequest.class));
    verify(mockFilterChain).doFilter(any(HttpServletRequest.class), any(HttpServletResponse.class));
  }
}
