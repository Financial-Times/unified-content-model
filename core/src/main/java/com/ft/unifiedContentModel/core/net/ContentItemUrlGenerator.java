package com.ft.unifiedContentModel.core.net;

import org.joda.time.DateTime;

public interface ContentItemUrlGenerator {

	Url createUrlForItems();

	Url createUrlForItem(String itemUuid);
    
	Url createUrlForItemWithLastModifiedDate(String itemUuid, DateTime lastModifiedDate);
	
	Url createUrlForItemWithHash(String itemUuid, String hash);

    Url createUrlForContentItemUpdateNotifications();

}
