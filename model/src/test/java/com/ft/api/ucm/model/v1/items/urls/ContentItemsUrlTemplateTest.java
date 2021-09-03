package com.ft.api.ucm.model.v1.items.urls;

import static net.obvj.junit.utils.matchers.AdvancedMatchers.throwsException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
    assertThat(
        () -> new ContentItemUrlTemplate(null), throwsException(IllegalArgumentException.class));
  }

  @Test
  public void shouldGenerateItemsUrl() {
    assertThat(template.generateUrl(), equalTo("http://api.ft.com/content/items/v1"));
  }
}
