package com.ft.unifiedContentModel.model.metadata;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@XmlTransient
@JsonDeserialize(as=TagImpl.class)
public interface Tag {
	
	Term getTerm();

}
