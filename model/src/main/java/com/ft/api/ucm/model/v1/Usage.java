package com.ft.api.ucm.model.v1;

import com.ft.api.ucm.model.v1.metadata.Term;
import java.util.Set;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@JsonDeserialize(as = UsageImpl.class)
public interface Usage {

  Set<Term> getPublications();
}
