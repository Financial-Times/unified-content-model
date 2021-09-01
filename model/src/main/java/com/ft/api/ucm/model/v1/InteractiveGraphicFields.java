package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"url", "id "})
public class InteractiveGraphicFields {

  private String url;
  private String id;

  public InteractiveGraphicFields() {}

  public InteractiveGraphicFields(String url, String id) {
    this.url = url;
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
