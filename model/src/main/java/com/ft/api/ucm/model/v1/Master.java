package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(as = MasterImpl.class)
@JsonPropertyOrder({"masterSource", "masterEntityId"})
public interface Master {

  String getMasterSource();

  String getMasterEntityId();
}
