package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as = StringBasedBody.class)
@JsonPropertyOrder({"mediaType", "body"})
public interface Body {
  String getBody();

  String getMediaType();
}
