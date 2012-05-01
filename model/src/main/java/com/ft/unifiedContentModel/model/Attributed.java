package com.ft.unifiedContentModel.model;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as=AttributionImpl.class)
public interface Attributed {

	String getByline();

	
}
