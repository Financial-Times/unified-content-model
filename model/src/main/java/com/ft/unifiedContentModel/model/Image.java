package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@XmlTransient
@JsonDeserialize(as=TypeBasedImage.class)
public interface Image {
	
	String getUrl();

	String getType();

	String getSource();

	String getAlt();

	String getCaption();

    Integer getHeight();

    Integer getWidth();

}