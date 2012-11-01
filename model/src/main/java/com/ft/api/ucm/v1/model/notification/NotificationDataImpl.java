package com.ft.api.ucm.v1.model.notification;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"content-item"})
public class NotificationDataImpl implements NotificationData, Serializable {

    private NotificationReference notificationReference;

    public NotificationDataImpl() {
    }

    public NotificationDataImpl(NotificationReference notificationReference) {
        this.notificationReference = notificationReference;
    }

    @Override
    @JsonProperty("content-item")
    public NotificationReference getNotificationReference() {
        return notificationReference;
    }

    @JsonDeserialize(as = ContentItemReference.class)
    public void setNotificationReference(NotificationReference notificationReference) {
        this.notificationReference = notificationReference;
    }
}
