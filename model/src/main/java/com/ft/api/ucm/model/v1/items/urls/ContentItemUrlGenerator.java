package com.ft.api.ucm.model.v1.items.urls;

import org.joda.time.DateTime;

import com.ft.api.ucm.core.net.HttpProtocol;

public interface ContentItemUrlGenerator {

	String createUrlForItems();
	
	@Deprecated
	String createUrlForItem(String itemUuid);
	
	String createUrlForItem(String uuid, HttpProtocol httpProtocol);
    
	String createUrlForItemWithLastModifiedDate(String itemUuid, DateTime lastModifiedDate);
	
	String createUrlForItemWithHash(String itemUuid, String hash);
}
