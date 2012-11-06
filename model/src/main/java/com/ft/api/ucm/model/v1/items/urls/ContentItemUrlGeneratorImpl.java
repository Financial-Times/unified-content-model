package com.ft.api.ucm.model.v1.items.urls;

import static com.ft.api.ucm.core.net.HexHashHelper.hexHash8;

import org.joda.time.DateTime;

import com.ft.api.ucm.core.net.ContentApiConfiguration;

public class ContentItemUrlGeneratorImpl implements ContentItemUrlGenerator {
	
    static final String CONTEXT_REGEX = "http[s]*://[A-Za-z0-9-.]+/content/[content|structure]([A-Za-z0-9-/.?=]+)";
    static final String ORIGINAL_REQUEST_HEADER_NAME = "X-Original-Request";

	private ContentItemUrlTemplate contentItemUrlTemplate;
	private ContentItemsUrlTemplate contentItemsUrlTemplate;
	
	public ContentItemUrlGeneratorImpl(ContentApiConfiguration configuration){
		contentItemUrlTemplate = new ContentItemUrlTemplate(configuration.getBaseApiUrl());
		contentItemsUrlTemplate = new ContentItemsUrlTemplate(configuration.getBaseApiUrl());
	}

	@Override
	public String createUrlForItems() {
		return contentItemsUrlTemplate.generateUrl();
	}

	@Override
	public String createUrlForItem(String itemUuid) {
		return contentItemUrlTemplate.generateUrl(itemUuid);
	}
	
	@Override
	public String createUrlForItemWithLastModifiedDate(String itemUuid, DateTime lastModifiedDate) {
		return contentItemUrlTemplate.generateUrl(itemUuid, hexHash8(lastModifiedDate));
	}
	
	@Override
	public String createUrlForItemWithHash(String itemUuid, String hash) {
		 return contentItemUrlTemplate.generateUrl(itemUuid, hash);
	}
	

}
