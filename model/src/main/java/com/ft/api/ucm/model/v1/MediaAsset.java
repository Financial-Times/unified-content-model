package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = OldSlideshow.class, name = "slideshow")})
public interface MediaAsset {
  String getName();

  void setName(String name);

  @JsonIgnore // we use uuid as key to index mediaAssets before the body has been processed
  String getUuid();
}
