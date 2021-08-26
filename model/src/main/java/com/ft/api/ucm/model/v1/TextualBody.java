package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as = TextualBodyImpl.class)
public interface TextualBody {
  @JsonProperty("isImageLed")
  boolean isImageLed();
}
