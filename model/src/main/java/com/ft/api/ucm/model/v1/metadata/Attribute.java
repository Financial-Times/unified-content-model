package com.ft.api.ucm.model.v1.metadata;

import com.ft.api.ucm.model.v1.KeyValue;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as=AttributeImpl.class)
public interface Attribute extends KeyValue<String,String> {

}
