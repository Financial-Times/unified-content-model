package com.ft.api.ucm.model.v1.items.urls;

import com.ft.api.ucm.core.net.HttpProtocol;
import org.joda.time.DateTime;

public interface ContentItemUrlGenerator {

  String createUrlForItems();

  @Deprecated
  String createUrlForItem(String itemUuid);

  String createUrlForItem(String uuid, HttpProtocol httpProtocol);

  @Deprecated
  String createUrlForItemWithLastModifiedDate(String itemUuid, DateTime lastModifiedDate);

  String createUrlForItemWithLastModifiedDate(
      String itemUuid, DateTime lastModifiedDate, HttpProtocol httpProtocol);

  String createUrlForItemWithHash(String itemUuid, String hash);
}
