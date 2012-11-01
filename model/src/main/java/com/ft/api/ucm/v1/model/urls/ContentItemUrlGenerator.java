package com.ft.api.ucm.v1.model.urls;

import org.joda.time.DateTime;

public interface ContentItemUrlGenerator {

	String createUrlForItems();

	String createUrlForItem(String itemUuid);
    
	String createUrlForItemWithLastModifiedDate(String itemUuid, DateTime lastModifiedDate);
	
	String createUrlForItemWithHash(String itemUuid, String hash);

	String createUrlForContentItemUpdateNotifications();

}
