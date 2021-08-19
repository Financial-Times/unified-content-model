package com.ft.api.ucm.model.v1.items.urls;

import static org.springframework.util.Assert.notNull;

public class ContentItemUrlTemplate {

  private static final String RELATIVE_TEMPLATE = "/content/items/v1/{itemId}";
  private static final String HASH_QUERY_PARAM = "h={hash}";

  private final String urlTemplate;

  public ContentItemUrlTemplate(String baseApiUrl) {
    notNull(baseApiUrl, "The template must have a non null base api url");
    this.urlTemplate = baseApiUrl + RELATIVE_TEMPLATE;
  }

  public String generateUrl(String itemId) {
    if (itemId == null) {
      throw new IllegalArgumentException(
          String.format("Unable to create url for item with itemId = '%s'.", itemId));
    }

    return urlTemplate.replace("{itemId}", itemId);
  }

  public String generateUrl(String itemId, String hash) {
    if (itemId == null) {
      throw new IllegalArgumentException(
          String.format("Unable to create url for item with itemId = '%s'.", itemId));
    }
    if (hash == null) {
      throw new IllegalArgumentException(
          String.format("Unable to create url for item with hash = '%s'.", hash));
    }
    String fullUrlTemplate = urlTemplate + "?" + HASH_QUERY_PARAM;
    return fullUrlTemplate.replace("{itemId}", itemId).replace("{hash}", hash);
  }
}
