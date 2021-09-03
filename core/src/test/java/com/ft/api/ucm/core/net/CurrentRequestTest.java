package com.ft.api.ucm.core.net;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.util.UrlPathHelper;

@ExtendWith(MockitoExtension.class)
public class CurrentRequestTest {

  private CurrentRequest currentRequestFormat;

  @Mock private HttpServletRequest httpServletRequest;
  @Mock private UrlPathHelper urlPathHelper;

  private static final String REQUEST_URL =
      "http://localhost/structure/pages/0d19f22d-9946-44a5-9198-9f181b195e99";

  @BeforeEach
  public void setup() {
    currentRequestFormat = new CurrentRequest();
    currentRequestFormat.setRequest(httpServletRequest);
    currentRequestFormat.setUrlPathHelper(urlPathHelper);
  }

  @Test
  public void testToString_xml() {
    String s = REQUEST_URL + ".xml";
    when(urlPathHelper.getRequestUri(httpServletRequest)).thenReturn(s);
    String actual = currentRequestFormat.getFormat();
    assertThat(actual, equalTo("xml"));
  }

  @Test
  public void testToString_json() {
    String s = REQUEST_URL + ".json";
    when(urlPathHelper.getRequestUri(httpServletRequest)).thenReturn(s);
    String actual = currentRequestFormat.getFormat();
    assertThat(actual, equalTo("json"));
  }

  @Test
  public void testToString_default() {
    when(urlPathHelper.getRequestUri(httpServletRequest)).thenReturn(REQUEST_URL);
    String actual = currentRequestFormat.getFormat();
    assertThat(actual, nullValue());
  }
}
