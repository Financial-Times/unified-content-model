package com.ft.unifiedContentModel.core.net;

public final class Paths {
	
	private Paths(){
		
	}
	
	public static final String ITEM_READ = "/content/items/v1/{itemId}";
	public static final String ITEM_LIST = "/content/items/v1";
	
	public static final String COMPONENT_READ = "/site/v1/pages/{pageId}/components/{componentId}";
    public static final String PAGE_CONTENT_READ = "/site/v1/pages/{pageId}/{componentVanityId}";
	
	public static final String PAGE_READ = "/site/v1/pages/{pageId}";
	public static final String PAGE_LIST = "/site/v1/pages";

    public static final String ITEM_NOTIFICATIONS_LIST = "content/notifications/v1/items";

}
