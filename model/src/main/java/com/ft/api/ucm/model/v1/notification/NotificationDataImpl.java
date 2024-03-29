package com.ft.api.ucm.model.v1.notification;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"content-item"})
public class NotificationDataImpl implements NotificationData, Serializable {

  private NotificationReference notificationReference;

  public NotificationDataImpl() {}

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
