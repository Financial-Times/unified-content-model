package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ft.api.ucm.model.v1.metadata.Term;
import java.util.Set;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@JsonDeserialize(as = UsageImpl.class)
public interface Usage {

  Set<Term> getPublications();
}
