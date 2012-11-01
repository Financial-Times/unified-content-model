package com.ft.api.ucm.v1.model.metadata;

import java.util.Set;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as=TermImpl.class)
public interface Term {
	
	String getId();
	String getName();
	String getTaxonomy(); 
	Set<Attribute> getAttributes();

}
