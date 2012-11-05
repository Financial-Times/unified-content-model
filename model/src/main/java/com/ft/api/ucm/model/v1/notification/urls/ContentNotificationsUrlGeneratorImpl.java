package com.ft.api.ucm.model.v1.notification.urls;

import static org.springframework.util.Assert.notNull;

import com.ft.api.ucm.core.net.Path;
import com.ft.api.ucm.core.net.PathFactory;
import com.ft.api.ucm.core.net.Paths;
import com.ft.api.ucm.core.net.UrlBuilder;

public class ContentNotificationsUrlGeneratorImpl implements ContentNotificationsUrlGenerator {

	private String baseApiUrl;

	private final PathFactory pathFactory;

	public ContentNotificationsUrlGeneratorImpl(PathFactory pathFactory) {
		notNull(pathFactory);
		this.pathFactory = pathFactory;
	}

	public ContentNotificationsUrlGeneratorImpl(String baseApiUrl,
			PathFactory pathFactory) {
		this(pathFactory);
		notNull(baseApiUrl);
		this.baseApiUrl = baseApiUrl;
	}

	public void setBaseApiUrl(String baseApiUrl) {
		notNull(baseApiUrl);
		this.baseApiUrl = baseApiUrl;
	}
	
	@Override
	public String createUrlForContentItemUpdateNotifications() {
		Path contentItemNotificationsPath = pathFactory.createPath(Paths.ITEM_NOTIFICATIONS_LIST);
		return UrlBuilder.basedOn(baseApiUrl)
				.withPathInfo(contentItemNotificationsPath.toString()).build();
	}

}
