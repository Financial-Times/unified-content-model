package com.ft.unifiedContentModel.core.datetime;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableDateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Before;
import org.junit.Test;

public class ISODateTimeWithMillisFormatterTest {

	private static final DateTime DATE_TIME = new DateTime();

		private ISODateTimeWithMillisFormatter instance;

		@Before
		public void setUp() throws Exception {
			instance = new ISODateTimeWithMillisFormatter();
		}

		@Test
		public void formatDateTime() {
			assertEquals(toIsoFormatWithUTCTimeZone(DATE_TIME), instance.format(DATE_TIME));
		}

		@Test(expected=IllegalArgumentException.class)
		public void nullDateInputThrowsException() {
			instance.format(null);
		}

		@Test
		public void whenAnIsoFormatStringIsProvidedADateIsReturned(){
			String text = "2011-07-14T23:58:04.123Z";
			ReadableDateTime dateTime = instance.parseDateTime(text);
			assertNotNull(dateTime);
		}

		@Test(expected=IllegalArgumentException.class)
		public void whenANonIsoFormatStringIsProvidedAnIllegalArgumentExceptionIsThrown(){
			String text = "2011-07-14";
			instance.parseDateTime(text);
		}

		@Test(expected=IllegalArgumentException.class)
		public void whenAnEmptyStringIsProvidedAnIllegalArgumentExceptionIsThrown(){
			String text = "";
			instance.parseDateTime(text);
		}

		@Test(expected=IllegalArgumentException.class)
		public void whenNullIsProvidedAnIllegalArgumentExceptionIsThrown(){
			String text = null;
			instance.parseDateTime(text);
		}

		@Test
		public void whenADateTimeIsFormattedAnIsoFormattedDateIsReturned(){
			String text = "2011-07-14T23:58:04.123Z";
			ReadableDateTime dateTime = new DateTime(2011, 7, 14, 23, 58, 4, 123, DateTimeZone.UTC);
			String formatted = instance.format(dateTime);
			assertEquals(text,formatted);
		}

		private String toIsoFormatWithUTCTimeZone(DateTime dateTime) {
			return dateTime.withZone(DateTimeZone.UTC).toString(ISODateTimeFormat.dateTime());
		}
}
