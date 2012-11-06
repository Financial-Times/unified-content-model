package com.ft.api.ucm.model.v1.notification.urls;

import org.springframework.util.Assert;

public class ContentNotificationsTemplate {

	private static final String URL_TEMPLATE = "/content/notifications/v1/items";

	private final String urlTemplate;

	public ContentNotificationsTemplate(String baseApiUrl) {
		Assert.notNull(baseApiUrl);
		this.urlTemplate = baseApiUrl + URL_TEMPLATE;
	}

	public String generateUrl() {
		return urlTemplate;
	}
	
}
