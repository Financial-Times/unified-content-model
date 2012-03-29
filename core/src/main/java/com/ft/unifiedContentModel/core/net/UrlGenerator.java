package com.ft.unifiedContentModel.core.net;


public interface UrlGenerator {
    Url createUrlForItems();
    Url createUrlForItem(String itemUuid);
    Url createUrlForPage(String pageUuid);
    Url createUrlForPages();
    Url createUrlForImage(String relativeImagePathInfo);
    Url createUrlForMainContentList(String pageUuid);
}
