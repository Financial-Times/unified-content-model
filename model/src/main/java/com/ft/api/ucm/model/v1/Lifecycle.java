package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as=LifecycleImpl.class)
public interface Lifecycle {
	
	DateTime getInitialPublishDateTime();
	
	DateTime getLastPublishDateTime();

}
