package com.ft.api.ucm.model.v1.notification.urls;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.api.ucm.core.net.ContentApiConfiguration;

@RunWith(MockitoJUnitRunner.class)
public class ContentNotificationUrlGeneratorImplTest {

	private static final String API_URL = "http://api.ft.com";
	
	private ContentNotificationsUrlGeneratorImpl generator;
    
    private @Mock ContentApiConfiguration configuration;

	@Before
	public void setup() {
		Mockito.when(configuration.getBaseApiUrl()).thenReturn(API_URL);
		generator = new ContentNotificationsUrlGeneratorImpl(configuration);
	}

    @Test
    public void contentItemNotificationsUrl(){
        String url = generator.createUrlForContentItemUpdateNotifications().toString();
        assertEquals("http://api.ft.com/content/notifications/v1/items", url);
    }

  

}
