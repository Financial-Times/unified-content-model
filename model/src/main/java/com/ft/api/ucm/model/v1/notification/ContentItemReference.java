package com.ft.api.ucm.model.v1.notification;

import java.io.Serializable;

public class ContentItemReference implements NotificationReference, Serializable {
  private String id;
  private String apiUrl;

  public ContentItemReference(String id, String apiUrl) {
    this.id = id;
    this.apiUrl = apiUrl;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getApiUrl() {
    return apiUrl;
  }

  public void setApiUrl(String apiUrl) {
    this.apiUrl = apiUrl;
  }
}
