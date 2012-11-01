package com.ft.api.ucm.model.v1.notification.urls;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.api.ucm.core.net.Path;
import com.ft.api.ucm.core.net.PathFactory;
import com.ft.api.ucm.core.net.Paths;

@RunWith(MockitoJUnitRunner.class)
public class ContentNotificationUrlGeneratorImplTest {

	private static final String API_URL = "http://api.ft.com";
	
	private ContentNotificationsUrlGeneratorImpl generator;
    
    private @Mock PathFactory mockPathFactory;
    private @Mock Path mockpath;

	@Before
	public void setup() {
		generator = new ContentNotificationsUrlGeneratorImpl(API_URL, mockPathFactory);
	}

    @Test
    public void contentItemNotificationsUrl(){
        when(mockpath.toString()).thenReturn(Paths.ITEM_NOTIFICATIONS_LIST);
        when(mockPathFactory.createPath(Mockito.eq(Paths.ITEM_NOTIFICATIONS_LIST))).thenReturn(mockpath);

        String url = generator.createUrlForContentItemUpdateNotifications().toString();
        assertEquals(API_URL + "/" + Paths.ITEM_NOTIFICATIONS_LIST, url);
    }

  

}
