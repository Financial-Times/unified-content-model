package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as = MasterImpl.class)
@JsonPropertyOrder({"masterSource", "masterEntityId"})
public interface Master {

  String getMasterSource();

  String getMasterEntityId();
}
