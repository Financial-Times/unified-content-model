package com.ft.api.ucm.model.v1.notification.urls;

import static net.obvj.junit.utils.matchers.AdvancedMatchers.throwsException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContentNotificationsTemplateTest {

  private static final String BASE_API_URL = "http://api.ft.com";
  private ContentNotificationsTemplate instance;

  @Test
  public void failsWithNullBaseApiUrl() {
    assertThat(
        () -> instance = new ContentNotificationsTemplate(null),
        throwsException(IllegalArgumentException.class));
  }

  @Test
  public void shouldGenerateNotificationUrl() {
    instance = new ContentNotificationsTemplate(BASE_API_URL);
    assertThat(instance.generateUrl(), equalTo("http://api.ft.com/content/notifications/v1/items"));
  }
}
