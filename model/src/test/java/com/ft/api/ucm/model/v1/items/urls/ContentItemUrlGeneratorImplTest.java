package com.ft.api.ucm.model.v1.items.urls;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.ft.api.ucm.core.net.ContentApiConfiguration;
import com.ft.api.ucm.core.net.HttpProtocol;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContentItemUrlGeneratorImplTest {

  private static final String API_URL = "http://api.ft.com";

  private static final String UUID = "123";
  private static final String HASH = "010203ef";

  private ContentItemUrlGeneratorImpl generator;

  private @Mock ContentApiConfiguration configuration;

  @BeforeEach
  public void setup() {
    when(configuration.getBaseApiUrl()).thenReturn(API_URL);
    generator = new ContentItemUrlGeneratorImpl(configuration);
  }

  @Test
  public void itemUrl() {
    String url = generator.createUrlForItem(UUID).toString();
    assertEquals("http://api.ft.com/content/items/v1/123", url);
  }

  @Test
  public void itemUrlHttp() {
    String url = generator.createUrlForItem(UUID, HttpProtocol.HTTP).toString();
    assertEquals("http://api.ft.com/content/items/v1/123", url);
  }

  @Test
  public void itemUrlHttps() {
    String url = generator.createUrlForItem(UUID, HttpProtocol.HTTPS).toString();
    assertEquals("https://api.ft.com/content/items/v1/123", url);
  }

  @Test
  public void shouldFailCreateUrlWithNullUuid() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> generator.createUrlForItem(null));
  }

  @Test
  public void itemsUrl() {
    String url = generator.createUrlForItems().toString();
    assertEquals("http://api.ft.com/content/items/v1", url);
  }

  @Test
  public void shouldCreateItemUrlWithLastModifiedQueryParam() throws Exception {
    DateTime dateTime =
        new DateTime()
            .withDate(2012, 07, 16)
            .withTime(13, 33, 56, 123)
            .withZoneRetainFields(DateTimeZone.UTC);
    String expectedHash = "900c4cfe";
    String url = generator.createUrlForItemWithLastModifiedDate(UUID, dateTime).toString();
    assertEquals("http://api.ft.com/content/items/v1/123?h=" + expectedHash, url);
  }

  @Test
  public void shouldCreateItemUrlWithLastModifiedQueryParamHttp() throws Exception {
    DateTime dateTime =
        new DateTime()
            .withDate(2012, 07, 16)
            .withTime(13, 33, 56, 123)
            .withZoneRetainFields(DateTimeZone.UTC);
    String expectedHash = "900c4cfe";
    String url =
        generator
            .createUrlForItemWithLastModifiedDate(UUID, dateTime, HttpProtocol.HTTP)
            .toString();
    assertEquals("http://api.ft.com/content/items/v1/123?h=" + expectedHash, url);
  }

  @Test
  public void shouldCreateItemUrlWithLastModifiedQueryParamHttps() throws Exception {
    DateTime dateTime =
        new DateTime()
            .withDate(2012, 07, 16)
            .withTime(13, 33, 56, 123)
            .withZoneRetainFields(DateTimeZone.UTC);
    String expectedHash = "900c4cfe";
    String url =
        generator
            .createUrlForItemWithLastModifiedDate(UUID, dateTime, HttpProtocol.HTTPS)
            .toString();
    assertEquals("https://api.ft.com/content/items/v1/123?h=" + expectedHash, url);
  }

  @Test
  public void shouldCreateItemUrlWithHash() throws Exception {
    String url = generator.createUrlForItemWithHash(UUID, HASH);
    assertEquals("http://api.ft.com/content/items/v1/123?h=010203ef", url);
  }

  @Test
  public void shouldFailCreateUrlWithNullHash() throws Exception {
    assertThrows(
        IllegalArgumentException.class, () -> generator.createUrlForItemWithHash(UUID, null));
  }

  @Test
  public void shouldFailCreateUrlWithHashButNullUuid() throws Exception {
    assertThrows(
        IllegalArgumentException.class, () -> generator.createUrlForItemWithHash(null, HASH));
  }
}
