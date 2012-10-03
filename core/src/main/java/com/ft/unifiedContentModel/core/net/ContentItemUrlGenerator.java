package com.ft.unifiedContentModel.core.net;

public interface ContentItemUrlGenerator {

	Url createUrlForItems();

	Url createUrlForItem(String itemUuid);
    
	Url createUrlForItemWithLastModifiedDate(String itemUuid, String lastModifiedDate);

    Url createUrlForContentItemUpdateNotifications();

}
