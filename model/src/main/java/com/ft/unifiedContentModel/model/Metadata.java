package com.ft.unifiedContentModel.model;

import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.ft.unifiedContentModel.model.metadata.Tag;

@XmlTransient
@JsonDeserialize(as=MetadataImpl.class)
public interface Metadata {

	Tag getPrimarySection();
	Tag getPrimaryTheme();
	Set<Tag> getTags();

}
