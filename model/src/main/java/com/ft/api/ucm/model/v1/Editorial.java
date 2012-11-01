package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as=EditorialImpl.class)
public interface Editorial extends Attributed {

	String getSubheading();
	String getLeadBody();
	String getStandFirst();
	
}
