package com.ft.api.ucm.model.v1.metadata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Set;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as = TermImpl.class)
public interface Term {

  String getId();

  String getName();

  String getTaxonomy();

  Set<Attribute> getAttributes();
}
