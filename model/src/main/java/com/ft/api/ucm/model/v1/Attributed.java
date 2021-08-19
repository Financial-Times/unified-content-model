package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = AttributionImpl.class)
public interface Attributed {

  String getByline();
}
