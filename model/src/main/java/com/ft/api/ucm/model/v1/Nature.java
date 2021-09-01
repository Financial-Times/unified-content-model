package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(as = NatureImpl.class)
public interface Nature {

  Category getCategory();
}
