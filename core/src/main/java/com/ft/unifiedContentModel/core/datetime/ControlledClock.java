package com.ft.unifiedContentModel.core.datetime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class ControlledClock implements Clock {
	
	private DateTime dateTime;
	
	public ControlledClock(long millis) {
		this.dateTime = new DateTime(millis, DateTimeZone.UTC);
	}

	@Override
	public long getTime() {
		return dateTime.getMillis();
	}


	@Override
	public boolean isBefore(long millis) {
		return dateTime.isBefore(millis);
	}

	@Override
	public boolean isAfter(long millis) {
		return dateTime.isAfter(millis);
	}
	
	@Override
	public String toString() {
		return dateTime.toString();
	}

	@Override
	public DateTime minsOffset(Integer minutes) {
		return dateTime.plusMinutes(minutes);
	}
}
