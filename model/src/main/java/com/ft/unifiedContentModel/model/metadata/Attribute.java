package com.ft.unifiedContentModel.model.metadata;

import com.ft.unifiedContentModel.model.KeyValue;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as=AttributeImpl.class)
public interface Attribute extends KeyValue<String,String> {

}
