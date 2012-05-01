package com.ft.unifiedContentModel.model;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as=TitleImpl.class)
public interface Title {
	
	String getTitle();
	
}
