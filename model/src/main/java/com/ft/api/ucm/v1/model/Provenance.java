package com.ft.api.ucm.v1.model;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as=ProvenanceImpl.class)
public interface Provenance {
	
	String getOriginatingParty();

}
