package com.ft.api.ucm.v1.model;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as=StringBasedBody.class)
@JsonPropertyOrder({"mediaType","body"})
public interface Body {
	String getBody();
    String getMediaType();
}
