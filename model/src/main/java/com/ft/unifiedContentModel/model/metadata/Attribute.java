package com.ft.unifiedContentModel.model.metadata;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.ft.unifiedContentModel.model.KeyValue;

@XmlTransient
@JsonDeserialize(as=AttributeImpl.class)
public interface Attribute extends KeyValue<String,String> {

}
