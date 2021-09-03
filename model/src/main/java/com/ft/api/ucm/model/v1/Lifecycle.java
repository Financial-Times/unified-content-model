package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.joda.time.DateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(as = LifecycleImpl.class)
public interface Lifecycle {

  DateTime getInitialPublishDateTime();

  DateTime getLastPublishDateTime();
}
