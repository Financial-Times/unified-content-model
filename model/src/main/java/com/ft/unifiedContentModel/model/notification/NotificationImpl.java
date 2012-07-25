package com.ft.unifiedContentModel.model.notification;

import com.ft.unifiedContentModel.core.datetime.JsonDateTimeWithMillisSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;

public class NotificationImpl implements Notification {

    private String type;
    private DateTime updated;
    private NotificationData data;

    public NotificationImpl() {
    }

    public NotificationImpl(String type, DateTime updated, NotificationData data) {
        this.type = type;
        this.updated = updated;
        this.data = data;
    }

    @Override
    public String getType() {
        return type;
    }

    @JsonSerialize(using=JsonDateTimeWithMillisSerializer.class, include=JsonSerialize.Inclusion.NON_NULL)
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
