package com.ft.api.ucm.v1.model.notification;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as=NotificationDataImpl.class)
public interface NotificationData {

    NotificationReference getNotificationReference();
}
