package com.ft.api.ucm.model.v1.notification.urls;

import com.ft.api.ucm.core.net.ContentApiConfiguration;

public class ContentNotificationsUrlGeneratorImpl implements ContentNotificationsUrlGenerator {

	
	private ContentNotificationsTemplate contentNotificationsTemplate;

	public ContentNotificationsUrlGeneratorImpl(ContentApiConfiguration configuration) {
		contentNotificationsTemplate = new ContentNotificationsTemplate(configuration.getBaseApiUrl());
	}

	@Override
	public String createUrlForContentItemUpdateNotifications() {
		return contentNotificationsTemplate.generateUrl();
	}

}
