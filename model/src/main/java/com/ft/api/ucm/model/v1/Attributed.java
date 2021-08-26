package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = AttributionImpl.class)
public interface Attributed {

  String getByline();
}
