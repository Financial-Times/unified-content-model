package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Set;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as = EditorialImpl.class)
public interface Editorial extends Attributed {

  String getSubheading();

  String getLeadBody();

  String getStandFirst();

  Set<String> getOtherTitles();
}
