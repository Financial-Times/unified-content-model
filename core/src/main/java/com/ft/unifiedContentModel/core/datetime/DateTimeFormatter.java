package com.ft.unifiedContentModel.core.datetime;

import org.joda.time.ReadableDateTime;

public interface DateTimeFormatter {
	
	String format(ReadableDateTime dateTime);
	
	ReadableDateTime parseDateTime(String dateTime);

}
