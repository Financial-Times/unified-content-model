package com.ft.api.ucm.model.v1.notification;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

public class NotificationImpl implements Notification {

  private String type;
  /* the updated dateTime should not be serialised but it is needed on this class to calculate the next batch's "since"
   */
  @JsonIgnore private DateTime updated;
  private NotificationData data;

  public NotificationImpl() {}

  public NotificationImpl(String type, DateTime updated, NotificationData data) {
    this.type = type;
    this.updated = updated;
    this.data = data;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public DateTime getUpdated() {
    return updated;
  }

  @Override
  public NotificationData getData() {
    return data;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setUpdated(DateTime updated) {
    this.updated = updated;
  }

  public void setData(NotificationData data) {
    this.data = data;
  }
}
