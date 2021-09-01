package com.ft.api.ucm.model.v1.items.urls;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContentItemsUrlTemplateTest {

  private static final String BASE_API_URL = "http://api.ft.com";

  private ContentItemsUrlTemplate template;

  @BeforeEach
  public void setup() {
    template = new ContentItemsUrlTemplate(BASE_API_URL);
  }

  @Test
  public void failsWithNullBaseApiUrl() {
    assertThrows(IllegalArgumentException.class, () -> new ContentItemUrlTemplate(null));
  }

  @Test
  public void shouldGenerateItemsUrl() {
    assertThat(template.generateUrl(), equalTo("http://api.ft.com/content/items/v1"));
  }
}
