package com.ft.unifiedContentModel.core.net;

import static org.springframework.util.Assert.notNull;

import java.util.Map;

import com.google.common.collect.Maps;

public class UrlGeneratorImpl implements UrlGenerator {
	
    static final String CONTEXT_REGEX = "http[s]*://[A-Za-z0-9-.]+/content/[content|structure]([A-Za-z0-9-/.?=]+)";
    static final String ORIGINAL_REQUEST_HEADER_NAME = "X-Original-Request";

    private String baseImageUrl;
    private String baseApiUrl;
    
    
    private final PathFactory pathFactory;
	private final String LAST_MODIFIED_DATE_PREFIX = "lastModified=";

	public UrlGeneratorImpl(PathFactory pathFactory) {
		notNull(pathFactory);
		this.pathFactory = pathFactory;
	}

    public UrlGeneratorImpl(String baseApiUrl, String baseImageUrl, PathFactory pathFactory) {
		this(pathFactory);
		notNull(baseApiUrl);
		notNull(baseImageUrl);
		this.baseApiUrl = baseApiUrl;
		this.baseImageUrl = baseImageUrl;
	}

	public void setBaseApiUrl(String baseApiUrl) {
		notNull(baseApiUrl);
		this.baseApiUrl = baseApiUrl;
	}
	
	public void setBaseImageUrl(String baseImageUrl) {
		notNull(baseImageUrl);
		this.baseImageUrl = baseImageUrl;
	}
	
	@Override
	public Url createUrlForItems() {
		Path itemListRelativePath = pathFactory.createPath(Paths.ITEM_LIST);
        return UrlBuilder.basedOn(baseApiUrl)
        		.withPathInfo(itemListRelativePath.toString())
        		.build();
			
	}

	@Override
	public Url createUrlForItem(String itemUuid) {
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("itemId", itemUuid);
		Path itemReadRelativePath = pathFactory.createPath(Paths.ITEM_READ, vars);
		
		return UrlBuilder.basedOn(baseApiUrl)
				.withPathInfo(itemReadRelativePath.toString())
				.build();
	}
	
	@Override
	public Url createUrlForImage(String relativeImagePathInfo) {
		return UrlBuilder.basedOn(baseImageUrl).withPathInfo(relativeImagePathInfo).build();
	}

    @Override
    public Url createUrlForContentItemUpdateNotifications() {
        Path contentItemNotificationsPath = pathFactory.createPath(Paths.ITEM_NOTIFICATIONS_LIST);

        return UrlBuilder.basedOn(baseApiUrl)
                .withPathInfo(contentItemNotificationsPath.toString())
                .build();
    }

	@Override
	public Url createUrlForItemWithLastModifiedDate(String itemUuid, String lastModifiedDate) {
		return UrlBuilder.basedOn(createUrlForItem(itemUuid).toString())
				.withQueryString(LAST_MODIFIED_DATE_PREFIX + lastModifiedDate)
				.build();
	}

	@Override
	public Url createRequestUrl(String servletPath, String pathInfo, String queryString) {
		return UrlBuilder.basedOn(baseApiUrl)
			.withPath(servletPath)
			.withPathInfo(pathInfo)
			.withQueryString(queryString)
			.build();
	}

}
