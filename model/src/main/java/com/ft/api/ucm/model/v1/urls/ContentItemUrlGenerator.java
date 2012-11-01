package com.ft.api.ucm.model.v1.urls;

import org.joda.time.DateTime;

public interface ContentItemUrlGenerator {

	String createUrlForItems();

	String createUrlForItem(String itemUuid);
    
	String createUrlForItemWithLastModifiedDate(String itemUuid, DateTime lastModifiedDate);
	
	String createUrlForItemWithHash(String itemUuid, String hash);

	String createUrlForContentItemUpdateNotifications();

}
