package com.ft.api.ucm.v1.model.metadata;

import com.ft.api.ucm.v1.model.KeyValue;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as=AttributeImpl.class)
public interface Attribute extends KeyValue<String,String> {

}
