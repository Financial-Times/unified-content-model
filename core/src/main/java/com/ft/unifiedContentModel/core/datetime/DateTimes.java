package com.ft.unifiedContentModel.core.datetime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * <p>Static utility methods pertaining to {@code DateTime} instances.</p>
 */
public final class DateTimes {
	
	static final DateTimeZone DEFAULT_ZONE = DateTimeZone.UTC;
	
	private DateTimes() {}
	
	/** Return the current DateTime, taking into account the default time zone. */
	public static DateTime now() {
		return new DateTime(DEFAULT_ZONE);
	}
}
