package com.ft.api.ucm.model.v1.notification;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = NotificationDataImpl.class)
public interface NotificationData {

  NotificationReference getNotificationReference();
}
