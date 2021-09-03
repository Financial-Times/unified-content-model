package com.ft.api.ucm.model.v1.notification;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.joda.time.DateTime;

@JsonDeserialize(as = NotificationImpl.class)
public interface Notification {

  String getType();

  DateTime getUpdated();

  NotificationData getData();
}
