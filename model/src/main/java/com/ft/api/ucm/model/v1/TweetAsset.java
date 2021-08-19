package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"name", "type", "fields"})
public class TweetAsset implements Asset {
  private String name;
  private TweetFields fields;

  public TweetAsset() {}

  public TweetAsset(TweetFields fields) {
    this.fields = fields;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  public TweetFields getFields() {
    return fields;
  }

  public void setFields(TweetFields fields) {
    this.fields = fields;
  }

  public void setType(String type) {}
}
