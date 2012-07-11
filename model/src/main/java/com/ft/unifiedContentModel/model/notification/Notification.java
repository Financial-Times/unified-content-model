package com.ft.unifiedContentModel.model.notification;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.joda.time.DateTime;

@JsonDeserialize(as=NotificationImpl.class)
public interface Notification {

    String getType();

    DateTime getUpdated();

    NotificationData getData();
}
