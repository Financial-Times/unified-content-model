package com.ft.unifiedContentModel.model.notification;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as=NotificationDataImpl.class)
public interface NotificationData {

    NotificationReference getNotificationReference();
}
