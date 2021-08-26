package com.ft.api.ucm.core.datetime;

import org.joda.time.DateTime;

/**
 * An abstraction to handle date/time related operations, to ensure collaborators are not tied to
 * the underlying OS time.
 */
public interface Clock {

  long getTime();

  boolean isBefore(long millis);

  boolean isAfter(long millis);

  DateTime minusMinutes(Integer minutes);
}
