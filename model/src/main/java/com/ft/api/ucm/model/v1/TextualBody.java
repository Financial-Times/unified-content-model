package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as = TextualBodyImpl.class)
public interface TextualBody {
  @JsonProperty("isImageLed")
  boolean isImageLed();
}
