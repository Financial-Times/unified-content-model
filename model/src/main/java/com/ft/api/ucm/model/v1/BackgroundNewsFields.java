package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"title", "body"})
public class BackgroundNewsFields {

  private String title;
  private String body;

  public BackgroundNewsFields() {}

  public BackgroundNewsFields(String title, String body) {
    this.title = title;
    this.body = body;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }
}
