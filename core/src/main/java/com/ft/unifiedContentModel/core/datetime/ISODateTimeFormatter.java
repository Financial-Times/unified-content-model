package com.ft.unifiedContentModel.core.datetime;


import static com.ft.unifiedContentModel.core.datetime.DateTimes.DEFAULT_ZONE;
import static org.springframework.util.Assert.notNull;

import org.joda.time.ReadableDateTime;
import org.joda.time.format.ISODateTimeFormat;

public class ISODateTimeFormatter implements DateTimeFormatter {
	
	static final org.joda.time.format.DateTimeFormatter DEFAULT_DATE_FORMATTER = ISODateTimeFormat.dateTime();
	
	@Override
	public String format(ReadableDateTime readableDateTime) {
		notNull(readableDateTime);
		return readableDateTime.toDateTime().withZone(DEFAULT_ZONE).toString(DEFAULT_DATE_FORMATTER);
	}

	@Override
	public ReadableDateTime parseDateTime(String dateTime) {
		notNull(dateTime);
		return DEFAULT_DATE_FORMATTER.parseDateTime(dateTime);
	}

}
