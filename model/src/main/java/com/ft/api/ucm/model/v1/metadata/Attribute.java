package com.ft.api.ucm.model.v1.metadata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ft.api.ucm.model.v1.KeyValue;

@JsonDeserialize(as = AttributeImpl.class)
public interface Attribute extends KeyValue<String, String> {}
