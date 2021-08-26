package com.ft.api.ucm.core.net;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HttpProtocolResolverTest {

  private static final String HTTP = "http";
  private static final String HTTPS = "https";
  private static final String HEADER_PROTOCOL_KEY = "X-Forwarded-Proto";
  private HttpProtocolResolver httpProtocolResolver;

  @Mock private HttpServletRequest mockHttpServletRequest;

  @Before
  public void setUp() {
    httpProtocolResolver = new HttpProtocolResolver();
  }

  @Test
  public void requestWithX_Forwarded_ProtoHeaderSetToHttp() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn(HTTP);

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertEquals(HttpProtocol.HTTP, httpProtocol);
  }

  @Test
  public void requestWithX_Forwarded_ProtoHeaderSetToHttpWithSpaces() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn(HTTP + "  ");

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertEquals(HttpProtocol.HTTP, httpProtocol);
  }

  @Test
  public void requestWithX_Forwarded_ProtoHeaderSetToHttpUppercase() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn(HTTP.toUpperCase());

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertEquals(HttpProtocol.HTTP, httpProtocol);
  }

  @Test
  public void requestWithX_Forwarded_ProtoHeaderSetToHttps() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn(HTTPS);

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertEquals(HttpProtocol.HTTPS, httpProtocol);
  }

  @Test
  public void requestWithX_Forwarded_ProtoHeaderSetToHttpsToUppercase() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn(HTTPS.toUpperCase());

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertEquals(HttpProtocol.HTTPS, httpProtocol);
  }

  @Test
  public void requestWithX_Forwarded_ProtoHeaderSetToSomethingOtherThanHttpOrHttps() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn("httpx");

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertEquals(HttpProtocol.HTTP, httpProtocol);
  }

  @Test
  public void requestWithNullX_Forwarded_ProtoHeader() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn(null);

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertEquals(HttpProtocol.HTTP, httpProtocol);
  }

  @Test
  public void requestWithEmptyX_Forwarded_ProtoHeader() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn("");

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertEquals(HttpProtocol.HTTP, httpProtocol);
  }

  @Test
  public void x_Forwarded_ProtoHeaderSetToNull() {
    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol((String) null);
    assertEquals(HttpProtocol.HTTP, httpProtocol);
  }

  @Test
  public void x_Forwarded_ProtoHeaderSetToEmtpy() {
    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol("");
    assertEquals(HttpProtocol.HTTP, httpProtocol);
  }

  @Test
  public void x_Forwarded_ProtoHeaderSetToUnknown() {
    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol("hello");
    assertEquals(HttpProtocol.HTTP, httpProtocol);
  }

  @Test
  public void x_Forwarded_ProtoHeaderSetToHttp() {
    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol("http");
    assertEquals(HttpProtocol.HTTP, httpProtocol);
  }

  @Test
  public void x_Forwarded_ProtoHeaderSetToHttpUppercase() {
    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol("HTTP");
    assertEquals(HttpProtocol.HTTP, httpProtocol);
  }

  @Test
  public void x_Forwarded_ProtoHeaderSetToHttps() {
    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol("https");
    assertEquals(HttpProtocol.HTTPS, httpProtocol);
  }

  @Test
  public void x_Forwarded_ProtoHeaderSetToHttpsUppercase() {
    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol("HTTPS");
    assertEquals(HttpProtocol.HTTPS, httpProtocol);
  }
}
