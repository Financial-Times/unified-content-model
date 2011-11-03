package com.ft.unifiedContentModel.core.datetime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class SystemClock implements Clock {
	
	@Override
	public long getTime() {
		return now().getMillis();
	}
	
	@Override
	public String toString() {
		return now().toString();
	}

	@Override
	public boolean isBefore(long millis) {
		return now().isBefore(millis);
	}

	@Override
	public boolean isAfter(long millis) {
		return now().isAfter(millis);
	}
	
	private DateTime now() {
		return new DateTime(DateTimeZone.UTC);
	}
}
