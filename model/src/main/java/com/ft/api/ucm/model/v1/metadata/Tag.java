package com.ft.api.ucm.model.v1.metadata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(as = TagImpl.class)
public interface Tag {

  Term getTerm();
}
