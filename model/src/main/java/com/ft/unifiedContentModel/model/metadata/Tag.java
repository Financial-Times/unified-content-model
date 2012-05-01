package com.ft.unifiedContentModel.model.metadata;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as=TagImpl.class)
public interface Tag {
	
	Term getTerm();

}
