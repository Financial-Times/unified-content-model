package com.ft.unifiedContentModel.core.datetime;

import org.joda.time.DateTime;

/**
 * <p>An abstraction to handle date/time related operations, to ensure collaborators 
 * are not tied to the underlying OS time.</p>
 */
public interface Clock {
	
	long getTime();
	
	boolean isBefore(long millis);
	
	boolean isAfter(long millis);

	DateTime minusMinutes(Integer minutes);
}
