package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Objects;

@JsonPropertyOrder({
  "aspectSet",
  "aspects",
  "modelVersion",
  "id",
  "apiUrl",
  "title",
  "lifecycle",
  "nature",
  "location",
  "summary",
  "master",
  "metadata",
  "images"
})
public class PageEntity extends ContentEntity implements Page {

  public PageEntity() {}

  public PageEntity(String id, String apiUrl) {
    super(id, apiUrl);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PageEntity) {
      PageEntity a = (PageEntity) o;
      return Objects.equal(this.getId(), a.getId());
    }
    return false;
  }

  @Override
  protected ToStringHelper toStringHelper() {
    ToStringHelper toStringHelper = super.toStringHelper();
    return toStringHelper
        .add("aspectSet", getAspectSet())
        .add("aspects", getAspects())
        .add("location", getLocation())
        .add("summary", getSummary())
        .add("metadata", getMetadata())
        .add("master", getMaster())
        .add("images", getImages());
  }
}
