package com.ft.api.ucm.model.v1.metadata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(as = TermImpl.class)
public interface Term {

  String getId();

  String getName();

  String getTaxonomy();

  Set<Attribute> getAttributes();
}
