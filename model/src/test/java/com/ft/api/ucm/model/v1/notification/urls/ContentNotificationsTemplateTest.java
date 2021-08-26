package com.ft.api.ucm.model.v1.notification.urls;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ContentNotificationsTemplateTest {

  private static final String BASE_API_URL = "http://api.ft.com";
  private ContentNotificationsTemplate instance;

  @Test(expected = IllegalArgumentException.class)
  public void failsWithNullBaseApiUrl() {
    instance = new ContentNotificationsTemplate(null);
  }

  @Test
  public void shouldGenerateNotificationUrl() {
    instance = new ContentNotificationsTemplate(BASE_API_URL);
    Assert.assertEquals("http://api.ft.com/content/notifications/v1/items", instance.generateUrl());
  }
}
