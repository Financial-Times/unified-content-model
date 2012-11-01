package com.ft.api.ucm.model.v1;

import com.ft.api.ucm.core.datetime.JsonDateTimeSerializer;
import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;

@JsonPropertyOrder({"initialPublishDateTime", "lastPublishDateTime"})
public class LifecycleImpl implements Lifecycle {

	private DateTime initialPublishDateTime;
	private DateTime lastPublishDateTime;
	
	public LifecycleImpl() { 
	}
	
	public LifecycleImpl(DateTime initialPublishDateTime, DateTime lastPublishDateTime) { 
		this.initialPublishDateTime = initialPublishDateTime;
		this.lastPublishDateTime = lastPublishDateTime;
	}	


    @JsonSerialize(using=JsonDateTimeSerializer.class, include=JsonSerialize.Inclusion.NON_NULL)
	@Override
	public DateTime getInitialPublishDateTime() {
		return initialPublishDateTime;
	}

    @JsonSerialize(using=JsonDateTimeSerializer.class, include=JsonSerialize.Inclusion.NON_NULL)
	@Override
	public DateTime getLastPublishDateTime() {
		return lastPublishDateTime;
	}
	
	public void setInitialPublishDateTime(DateTime initialPublishDateTime){
		this.initialPublishDateTime = initialPublishDateTime;
	}
	
	public void setLastPublishDateTime(DateTime lastPublishDateTime) {
		this.lastPublishDateTime = lastPublishDateTime;
	}

    @Override
	public String toString() {
		return Objects.toStringHelper(this).add("lastPublishDateTime", lastPublishDateTime).toString();
	}

}
