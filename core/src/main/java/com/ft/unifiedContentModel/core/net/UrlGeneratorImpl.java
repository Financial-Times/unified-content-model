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
		setBaseApiUrl(baseApiUrl);
		setBaseImageUrl(baseImageUrl);
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
	public Url createUrlForComponent(String pageUuid, String componentUuid) {
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("pageId", pageUuid);
		vars.put("componentId", componentUuid);
		Path componentReadRelativePath = pathFactory.createPath(Paths.COMPONENT_READ, vars);

		return UrlBuilder.basedOn(baseApiUrl)
				.withPathInfo(componentReadRelativePath.toString())
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
				.overridePaths(pageListRelativePath.toString())
				.build();
	}
	
	@Override
	public Url createUrlForImage(String relativeImagePathInfo) {
		return UrlBuilder.basedOn(baseImageUrl).withPathInfo(relativeImagePathInfo).build();
	}

}
