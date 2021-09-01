package com.ft.api.ucm.model.v1.items.urls;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContentItemUrlTemplateTest {

  private static final String BASE_API_URL = "http://api.ft.com";
  private static final String ITEM_UUID = "1234";
  private static final String HASH = "e40ab533";

  private ContentItemUrlTemplate template;

  @BeforeEach
  public void setup() {
    template = new ContentItemUrlTemplate(BASE_API_URL);
  }

  @Test
  public void failsWithNullBaseApiUrl() {
    assertThrows(IllegalArgumentException.class, () -> new ContentItemUrlTemplate(null));
  }

  @Test
  public void shouldGenerateItemUrl() {
    assertThat(template.generateUrl(ITEM_UUID), equalTo("http://api.ft.com/content/items/v1/1234"));
  }

  @Test
  public void shouldGenerateItemUrlWithHash() {
    assertEquals(
        "http://api.ft.com/content/items/v1/1234?h=e40ab533",
        template.generateUrl(ITEM_UUID, HASH));
  }

  @Test
  public void shouldFailToGenerateWithNullItemUuid() {
    assertThrows(IllegalArgumentException.class, () -> template.generateUrl(null));
  }

  @Test
  public void shouldFailWithHashAndNullId() {
    assertThrows(IllegalArgumentException.class, () -> template.generateUrl(null, HASH));
  }

  @Test
  public void shouldFailWithNullHash() {
    assertThrows(IllegalArgumentException.class, () -> template.generateUrl(ITEM_UUID, null));
  }
}
