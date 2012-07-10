package com.ft.unifiedContentModel.model.notification;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

public class NotificationDataImpl implements NotificationData, Serializable {

    private NotificationReference notificationReference;

    public NotificationDataImpl() {
    }

    public NotificationDataImpl(NotificationReference notificationReference) {
        this.notificationReference = notificationReference;
    }

    @Override
    public NotificationReference getNotificationReference() {
        return notificationReference;
    }

    @JsonDeserialize(as = ContentItemReference.class)
    @JsonProperty("content-item")
    public void setNotificationReference(NotificationReference notificationReference) {
        this.notificationReference = notificationReference;
    }
}
