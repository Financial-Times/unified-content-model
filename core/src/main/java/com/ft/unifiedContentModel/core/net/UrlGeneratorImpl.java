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
	public Url createUrlForPage(String pageUuid) {
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("pageId", pageUuid);
		Path pageReadRelativePath = pathFactory.createPath(Paths.PAGE_READ, vars);
		
		return UrlBuilder.basedOn(baseApiUrl)
				.withPathInfo(pageReadRelativePath.toString())
				.build();
	}
	
	@Override
	public Url createUrlForPages() {
		Path pageListRelativePath = pathFactory.createPath(Paths.PAGE_LIST);
		
		return UrlBuilder.basedOn(baseApiUrl)
				.withPathInfo(pageListRelativePath.toString())
				.build();
	}
	
	@Override
	public Url createUrlForImage(String relativeImagePathInfo) {
		return UrlBuilder.basedOn(baseImageUrl).withPathInfo(relativeImagePathInfo).build();
	}

    @Override
    public Url createUrlForContentList(String pageUuid, String componentVanityId) {
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("pageId", pageUuid);
        vars.put("componentVanityId", componentVanityId);
		Path contentReadRelativePath = pathFactory.createPath(Paths.PAGE_CONTENT_READ, vars);

		return UrlBuilder.basedOn(baseApiUrl)
				.withPathInfo(contentReadRelativePath.toString())
				.build();
    }

}
