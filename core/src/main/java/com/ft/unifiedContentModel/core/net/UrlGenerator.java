package com.ft.unifiedContentModel.core.net;


public interface UrlGenerator {
    Url createUrlForItems();
    Url createUrlForItem(String itemUuid);
    Url createUrlForPage(String pageUuid);
    Url createUrlForPages();
    Url createUrlForComponent(String pageUuid, String componentUuid);
    Url createUrlForImage(String relativeImagePathInfo);
}
