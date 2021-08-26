package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as = PackagingImpl.class)
public interface Packaging {

  String getKicker();

  String getSpHeadline();
}
