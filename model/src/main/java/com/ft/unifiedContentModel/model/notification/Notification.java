package com.ft.unifiedContentModel.model.notification;

import org.joda.time.DateTime;

public interface Notification {

    String getType();

    DateTime getUpdated();

    NotificationData getData();
}
