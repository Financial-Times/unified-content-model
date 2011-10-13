package com.ft.unifiedContentModel.model.metadata;

import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@XmlTransient
@JsonDeserialize(as=TermImpl.class)
public interface Term {
	
	String getId();
	String getName();
	String getTaxonomy(); 
	Set<Attribute> getAttributes();

}
