package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(as = EditorialImpl.class)
public interface Editorial extends Attributed {

  String getSubheading();

  String getLeadBody();

  String getStandFirst();

  Set<String> getOtherTitles();
}
