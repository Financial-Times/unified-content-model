package com.ft.unifiedContentModel.core.net;

public final class Paths {
	
	private Paths(){
		
	}
	
	public static final String ITEM_READ = "/content/items/v1/{itemId}";
	public static final String ITEM_READ_MULTIPLE = "/content/items/[{itemIds}]";
	public static final String ITEM_LIST = "/content/items";
	
	public static final String COMPONENT_READ = "/structure/pages/{pageId}/components/{componentId}";
	
	public static final String PAGE_READ = "/structure/pages/{pageId}";
	public static final String PAGE_LIST = "/structure/pages";

	
}
