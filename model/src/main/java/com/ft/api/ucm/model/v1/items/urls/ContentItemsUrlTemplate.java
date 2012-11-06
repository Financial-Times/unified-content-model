package com.ft.api.ucm.model.v1.items.urls;

public class ContentItemsUrlTemplate {
	
	private static final String URL_TEMPLATE = "/content/items/v1";

	private final String urlTemplate;

	public ContentItemsUrlTemplate(String baseApiUrl) {
		this.urlTemplate = baseApiUrl + URL_TEMPLATE;
	}

	public String generateUrl() {
		return urlTemplate;
	}

}
