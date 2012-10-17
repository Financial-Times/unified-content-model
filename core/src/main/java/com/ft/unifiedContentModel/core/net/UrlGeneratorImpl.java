package com.ft.unifiedContentModel.core.net;

import static org.springframework.util.Assert.notNull;

import java.util.Map;

import org.joda.time.DateTime;

import com.google.common.collect.Maps;

public class UrlGeneratorImpl implements UrlGenerator {
	
    static final String CONTEXT_REGEX = "http[s]*://[A-Za-z0-9-.]+/content/[content|structure]([A-Za-z0-9-/.?=]+)";
    static final String ORIGINAL_REQUEST_HEADER_NAME = "X-Original-Request";

    private String baseApiUrl;
    
    
    private final PathFactory pathFactory;
	private final String LAST_MODIFIED_DATE_PREFIX = "lastModified=";
	private final String HASH_PREFIX = "h=";

	public UrlGeneratorImpl(PathFactory pathFactory) {
		notNull(pathFactory);
		this.pathFactory = pathFactory;
	}

    public UrlGeneratorImpl(String baseApiUrl, PathFactory pathFactory) {
		this(pathFactory);
		notNull(baseApiUrl);
		this.baseApiUrl = baseApiUrl;
	}

	public void setBaseApiUrl(String baseApiUrl) {
		notNull(baseApiUrl);
		this.baseApiUrl = baseApiUrl;
	}
	
	@Override
	public Url createUrlForItems() {
		Path itemListRelativePath = pathFactory.createPath(Paths.ITEM_LIST);
		return buildItemUrl(itemListRelativePath);
	}

	@Override
	public Url createUrlForItem(String itemUuid) {
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("itemId", itemUuid);
		Path itemReadRelativePath = pathFactory.createPath(Paths.ITEM_READ, vars);
		return buildItemUrl(itemReadRelativePath);
	}
	
	protected Url buildItemUrl(Path itemReadRelativePath) {
		return UrlBuilder.basedOn(baseApiUrl)
				.withPathInfo(itemReadRelativePath.toString())
				.build();
	}
	
    @Override
    public Url createUrlForContentItemUpdateNotifications() {
        Path contentItemNotificationsPath = pathFactory.createPath(Paths.ITEM_NOTIFICATIONS_LIST);
        return buildItemUrl(contentItemNotificationsPath);
    }

	@Override
	public Url createUrlForItemWithLastModifiedDate(String itemUuid, DateTime lastModifiedDate) {
		return createUrlForItemWithHash(itemUuid, HexHashHelper.hexHash8(lastModifiedDate));
	}
	
	@Override
	public Url createUrlForItemWithHash(String itemUuid, String hash) {
		return UrlBuilder.basedOn(createUrlForItem(itemUuid).toString())
				.withQueryString(HASH_PREFIX + hash)
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
