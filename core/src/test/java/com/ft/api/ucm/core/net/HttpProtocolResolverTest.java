package com.ft.api.ucm.core.net;

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
public class HttpProtocolResolverTest {

  private static final String HTTP = "http";
  private static final String HTTPS = "https";
  private static final String HEADER_PROTOCOL_KEY = "X-Forwarded-Proto";
  private HttpProtocolResolver httpProtocolResolver;

  @Mock private HttpServletRequest mockHttpServletRequest;

  @BeforeEach
  public void setUp() {
    httpProtocolResolver = new HttpProtocolResolver();
  }

  @Test
  public void requestWithX_Forwarded_ProtoHeaderSetToHttp() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn(HTTP);

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertThat(HttpProtocol.HTTP, equalTo(httpProtocol));
  }

  @Test
  public void requestWithX_Forwarded_ProtoHeaderSetToHttpWithSpaces() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn(HTTP + "  ");

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertThat(HttpProtocol.HTTP, equalTo(httpProtocol));
  }

  @Test
  public void requestWithX_Forwarded_ProtoHeaderSetToHttpUppercase() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn(HTTP.toUpperCase());

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertThat(HttpProtocol.HTTP, equalTo(httpProtocol));
  }

  @Test
  public void requestWithX_Forwarded_ProtoHeaderSetToHttps() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn(HTTPS);

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertThat(HttpProtocol.HTTPS, equalTo(httpProtocol));
  }

  @Test
  public void requestWithX_Forwarded_ProtoHeaderSetToHttpsToUppercase() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn(HTTPS.toUpperCase());

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertThat(HttpProtocol.HTTPS, equalTo(httpProtocol));
  }

  @Test
  public void requestWithX_Forwarded_ProtoHeaderSetToSomethingOtherThanHttpOrHttps() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn("httpx");

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertThat(HttpProtocol.HTTP, equalTo(httpProtocol));
  }

  @Test
  public void requestWithNullX_Forwarded_ProtoHeader() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn(null);

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertThat(HttpProtocol.HTTP, equalTo(httpProtocol));
  }

  @Test
  public void requestWithEmptyX_Forwarded_ProtoHeader() {
    when(mockHttpServletRequest.getHeader(HEADER_PROTOCOL_KEY)).thenReturn("");

    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol(mockHttpServletRequest);
    assertThat(HttpProtocol.HTTP, equalTo(httpProtocol));
  }

  @Test
  public void x_Forwarded_ProtoHeaderSetToNull() {
    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol((String) null);
    assertThat(HttpProtocol.HTTP, equalTo(httpProtocol));
  }

  @Test
  public void x_Forwarded_ProtoHeaderSetToEmtpy() {
    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol("");
    assertThat(HttpProtocol.HTTP, equalTo(httpProtocol));
  }

  @Test
  public void x_Forwarded_ProtoHeaderSetToUnknown() {
    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol("hello");
    assertThat(HttpProtocol.HTTP, equalTo(httpProtocol));
  }

  @Test
  public void x_Forwarded_ProtoHeaderSetToHttp() {
    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol("http");
    assertThat(HttpProtocol.HTTP, equalTo(httpProtocol));
  }

  @Test
  public void x_Forwarded_ProtoHeaderSetToHttpUppercase() {
    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol("HTTP");
    assertThat(HttpProtocol.HTTP, equalTo(httpProtocol));
  }

  @Test
  public void x_Forwarded_ProtoHeaderSetToHttps() {
    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol("https");
    assertThat(HttpProtocol.HTTPS, equalTo(httpProtocol));
  }

  @Test
  public void x_Forwarded_ProtoHeaderSetToHttpsUppercase() {
    HttpProtocol httpProtocol = httpProtocolResolver.getProtocol("HTTPS");
    assertThat(HttpProtocol.HTTPS, equalTo(httpProtocol));
  }
}
