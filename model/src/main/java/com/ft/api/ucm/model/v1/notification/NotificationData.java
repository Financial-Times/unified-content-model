package com.ft.api.ucm.model.v1.notification;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as = NotificationDataImpl.class)
public interface NotificationData {

  NotificationReference getNotificationReference();
}
