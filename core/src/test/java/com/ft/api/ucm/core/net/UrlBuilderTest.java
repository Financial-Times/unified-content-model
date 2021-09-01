package com.ft.api.ucm.core.net;

import static net.obvj.junit.utils.matchers.AdvancedMatchers.throwsException;
import static org.apache.commons.lang3.CharEncoding.UTF_8;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.web.util.UriUtils.encodePath;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class UrlBuilderTest {

  private static final String SCHEME = "http";
  private static final String SECURE_SCHEME = "https";
  private static final String SERVER_NAME = "localhost";
  private static final String NON_STANDARD_PORT = "8080";
  private static final int DEFAULT_HTTP_PORT = 80;
  private static final int DEFAULT_HTTPS_PORT = 443;
  private static final String SERVLET_PATH = "/1234567/resource";
  private static final String SERVLET_PATH_WITH_SPECIAL_CHARS = "/[SPECIAL]/resource";
  private static final String QUERY_STRING = "limit=5&offset=0";
  private static final String NEW_SERVLET_PATH = "/test/success";

  private static final String EXPECTED_URL_STRING =
      SCHEME + "://" + SERVER_NAME + ":" + NON_STANDARD_PORT + SERVLET_PATH;

  @Test
  public void basedOnExistingRequest() {
    assertThat(UrlBuilder.basedOn(newRequest(), false).toString(), equalTo(EXPECTED_URL_STRING));
  }

  @Test
  public void basedOnExistingRequestIncludingParams() {
    MockHttpServletRequest request = newRequest();
    request.setQueryString(QUERY_STRING);
    assertThat(
        UrlBuilder.basedOn(request, true).toString(),
        equalTo(EXPECTED_URL_STRING + '?' + QUERY_STRING));
  }

  @Test
  public void basedOnExistingRequestIncludingParamsWhereNotNull() {
    MockHttpServletRequest request = newRequest();
    request.setQueryString(null);
    assertThat(UrlBuilder.basedOn(request, true).toString(), equalTo(EXPECTED_URL_STRING));
  }

  @Test
  public void basedOnStringUrl() {
    String baseUrl = "http://int.media.ft.com/content/images?true=false";
    assertThat(UrlBuilder.basedOn(baseUrl).toString(), equalTo(baseUrl));
  }

  @Test
  public void basedOnStringUrlHttps() {
    String baseUrl = "https://int.media.ft.com:443/content/images?true=false";
    String expectedUrl = "https://int.media.ft.com/content/images?true=false";
    assertThat(UrlBuilder.basedOn(baseUrl).toString(), equalTo(expectedUrl));
  }

  @Test
  public void withNewPath() {
    assertThat(
        UrlBuilder.basedOn(newRequest(), false).withPath(NEW_SERVLET_PATH).toString(),
        equalTo(SCHEME + "://" + SERVER_NAME + ":" + NON_STANDARD_PORT + NEW_SERVLET_PATH));
  }

  @Test
  public void specialCharsEncoded() {
    assertThat(
        UrlBuilder.basedOn(newRequest(), false)
            .withPath(NEW_SERVLET_PATH)
            .withPath(NEW_SERVLET_PATH)
            .withPath(SERVLET_PATH_WITH_SPECIAL_CHARS)
            .toString(),
        equalTo(
            SCHEME
                + "://"
                + SERVER_NAME
                + ":"
                + NON_STANDARD_PORT
                + encodePath(SERVLET_PATH_WITH_SPECIAL_CHARS, UTF_8)));
  }

  @Test
  public void withRootContextPath() {
    MockHttpServletRequest request = newRequest();
    request.setContextPath("/");
    assertThat(
        UrlBuilder.basedOn(request, false).toString(),
        equalTo(SCHEME + "://" + SERVER_NAME + ":" + NON_STANDARD_PORT + SERVLET_PATH));
  }

  @Test
  public void withNullRequest() {
    assertThat(
        () -> UrlBuilder.basedOn(null, false), throwsException(IllegalArgumentException.class));
  }

  @Test
  public void withInvalidScheme() {
    assertThat(
        () -> UrlBuilder.basedOn(newRequest(), false).withScheme("httttttttppppddd"),
        throwsException(IllegalArgumentException.class));
  }

  @Test
  public void withNegativePortCorrected() {
    assertThat(
        UrlBuilder.basedOn(newRequest(), false).withPort(-20).toString(),
        equalTo(SCHEME + "://" + SERVER_NAME + SERVLET_PATH));
  }

  @Test
  public void withZeroPortCorrected() {
    assertThat(
        UrlBuilder.basedOn(newRequest(), false).withPort(0).toString(),
        equalTo(SCHEME + "://" + SERVER_NAME + SERVLET_PATH));
  }

  @Test
  public void defaultHttpPortNotWritten() {
    assertThat(
        UrlBuilder.basedOn(newRequest(), false).withPort(DEFAULT_HTTP_PORT).toString(),
        equalTo(SCHEME + "://" + SERVER_NAME + SERVLET_PATH));
  }

  @Test
  public void defaultHttpsPortNotWritten() {
    assertThat(
        UrlBuilder.basedOn(newRequest(), false)
            .withPort(DEFAULT_HTTPS_PORT)
            .withScheme(SECURE_SCHEME)
            .toString(),
        equalTo(SECURE_SCHEME + "://" + SERVER_NAME + SERVLET_PATH));
  }

  @Test
  public void overridePaths() {
    assertThat(
        UrlBuilder.basedOn(newRequest(), false)
            .withPort(DEFAULT_HTTP_PORT)
            .overridePaths("/newServletPath")
            .toString(),
        equalTo(SCHEME + "://" + SERVER_NAME + "/newServletPath"));
  }

  private MockHttpServletRequest newRequest() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setScheme(SCHEME);
    request.setServerName(SERVER_NAME);
    request.setServerPort(Integer.parseInt(NON_STANDARD_PORT));
    request.setServletPath(SERVLET_PATH);
    return request;
  }
}
