package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.joda.time.DateTime;

@XmlTransient
@JsonDeserialize(as=LifecycleImpl.class)
public interface Lifecycle {
	
	DateTime getInitialPublishDateTime();
	
	DateTime getLastPublishDateTime();

}
