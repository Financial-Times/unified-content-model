package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as = MasterImpl.class)
@JsonPropertyOrder({"masterSource", "masterEntityId"})
public interface Master {

  String getMasterSource();

  String getMasterEntityId();
}
