package com.ft.api.ucm.model.v1.notification.urls;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContentNotificationUrlGeneratorImplTest {

  private static final String API_URL = "http://api.ft.com";

  private ContentNotificationsUrlGeneratorImpl generator;

  private @Mock ContentApiConfiguration configuration;

  @BeforeEach
  public void setup() {
    when(configuration.getBaseApiUrl()).thenReturn(API_URL);
    generator = new ContentNotificationsUrlGeneratorImpl(configuration);
  }

  @Test
  public void contentItemNotificationsUrl() {
    String url = generator.createUrlForContentItemUpdateNotifications().toString();
    assertThat("http://api.ft.com/content/notifications/v1/items", equalTo(url));
  }
}
