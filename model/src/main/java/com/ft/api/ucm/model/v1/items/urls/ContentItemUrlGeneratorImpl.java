package com.ft.api.ucm.model.v1.items.urls;

import static org.springframework.util.Assert.notNull;

import java.util.Map;

import org.joda.time.DateTime;

import com.ft.unifiedContentModel.core.net.HexHashHelper;
import com.ft.unifiedContentModel.core.net.Path;
import com.ft.unifiedContentModel.core.net.PathFactory;
import com.ft.unifiedContentModel.core.net.Paths;
import com.ft.unifiedContentModel.core.net.Url;
import com.ft.unifiedContentModel.core.net.UrlBuilder;
import com.google.common.collect.Maps;

public class ContentItemUrlGeneratorImpl implements ContentItemUrlGenerator {
	
    static final String CONTEXT_REGEX = "http[s]*://[A-Za-z0-9-.]+/content/[content|structure]([A-Za-z0-9-/.?=]+)";
    static final String ORIGINAL_REQUEST_HEADER_NAME = "X-Original-Request";

    private String baseApiUrl;
    
    private final PathFactory pathFactory;
	private final String HASH_PREFIX = "h=";

	public ContentItemUrlGeneratorImpl(PathFactory pathFactory) {
		notNull(pathFactory);
		this.pathFactory = pathFactory;
	}

    public ContentItemUrlGeneratorImpl(String baseApiUrl, PathFactory pathFactory) {
		this(pathFactory);
		notNull(baseApiUrl);
		this.baseApiUrl = baseApiUrl;
	}

	public void setBaseApiUrl(String baseApiUrl) {
		notNull(baseApiUrl);
		this.baseApiUrl = baseApiUrl;
	}
	
	@Override
	public String createUrlForItems() {
		Path itemListRelativePath = pathFactory.createPath(Paths.ITEM_LIST);
		return buildItemUrl(itemListRelativePath).getUrl();
	}

	@Override
	public String createUrlForItem(String itemUuid) {
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("itemId", itemUuid);
		Path itemReadRelativePath = pathFactory.createPath(Paths.ITEM_READ, vars);
		return buildItemUrl(itemReadRelativePath).getUrl();
	}
	
	protected Url buildItemUrl(Path itemReadRelativePath) {
		return UrlBuilder.basedOn(baseApiUrl)
				.withPathInfo(itemReadRelativePath.toString())
				.build();
	}
	
	@Override
	public String createUrlForItemWithLastModifiedDate(String itemUuid, DateTime lastModifiedDate) {
		return createUrlForItemWithHash(itemUuid, HexHashHelper.hexHash8(lastModifiedDate));
	}
	
	@Override
	public String createUrlForItemWithHash(String itemUuid, String hash) {
		return UrlBuilder.basedOn(createUrlForItem(itemUuid).toString())
				.withQueryString(HASH_PREFIX + hash)
				.build().getUrl();
	}

}
