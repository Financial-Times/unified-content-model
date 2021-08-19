package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(as = LifecycleImpl.class)
public interface Lifecycle {

  DateTime getInitialPublishDateTime();

  DateTime getLastPublishDateTime();
}
