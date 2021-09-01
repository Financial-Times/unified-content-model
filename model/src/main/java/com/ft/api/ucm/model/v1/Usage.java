package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ft.api.ucm.model.v1.metadata.Term;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(as = UsageImpl.class)
public interface Usage {

  Set<Term> getPublications();
}
