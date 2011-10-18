package com.ft.unifiedContentModel.ws.http;

import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.unifiedContentModel.core.datetime.DateTimeFormatter;
import com.ft.unifiedContentModel.ws.http.LastBuiltResponseHeader;

import static com.ft.unifiedContentModel.core.datetime.DateTimes.now;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class LastBuiltResponseHeaderTest {
	
	private static final DateTime FIXED_DATE_TIME = now();
	
	@Mock private HttpServletResponse mockResponse;
	@Mock private DateTimeFormatter mockDateTimeFormatter;
	
	private LastBuiltResponseHeader instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new LastBuiltResponseHeader(mockDateTimeFormatter);
	}

	@Test
	public void fixedDateSetOnResponse() {
		when(mockDateTimeFormatter.format(FIXED_DATE_TIME)).thenReturn(toDefaultFormat(FIXED_DATE_TIME));
		instance.setFixedLastBuiltDateTime(FIXED_DATE_TIME);
		instance.setOn(mockResponse);
		verify(mockResponse).addHeader(LastBuiltResponseHeader.LAST_BUILT_HEADER_NAME, toDefaultFormat(FIXED_DATE_TIME));
	}
	
	@Ignore
	@Test
	public void dynamicDateSetOnResponse() {
		when(mockDateTimeFormatter.format(any(DateTime.class))).thenReturn(toDefaultFormat(now()));
		instance.setOn(mockResponse);
		verify(mockResponse).addHeader(eq(LastBuiltResponseHeader.LAST_BUILT_HEADER_NAME), isDateBeforeNow());
	}
	
	private String isDateBeforeNow() {
		return argThat(new ArgumentMatcher<String>() {
			@Override
			public boolean matches(Object argument) {
				DateTime headerValue = new DateTime(argument);
				return headerValue.isBefore(now());
			}
		});
	}
	
	private String toDefaultFormat(DateTime dateTime) {
		return dateTime.withZone(DateTimeZone.UTC).toString(ISODateTimeFormat.dateTime());
	}
	
}
