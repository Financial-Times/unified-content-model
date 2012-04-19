package com.ft.unifiedContentModel.core.net;



public interface UrlGenerator {
    Url createUrlForItems();
    Url createUrlForItem(String itemUuid);
    Url createUrlForPage(String pageUuid);
    Url createUrlForPages();
    Url createUrlForImage(String relativeImagePathInfo);
    Url createUrlForContentList(String pageUuid, String contentVanityId);
    
    Url createRequestUrl(String servletPath, String pathInfo, String queryString);
    
}
