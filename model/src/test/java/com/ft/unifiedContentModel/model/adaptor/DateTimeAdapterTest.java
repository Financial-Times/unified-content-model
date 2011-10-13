package com.ft.unifiedContentModel.model.adaptor;

import static org.apache.commons.lang.StringUtils.EMPTY;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.joda.time.ReadableDateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.unifiedContentModel.core.datetime.DateTimeFormatter;
import com.ft.unifiedContentModel.model.adaptor.DateTimeAdapter;

@RunWith(MockitoJUnitRunner.class)
public class DateTimeAdapterTest {
	
	private static final String DATE_STRING = "2011-03-26T12:00:00.000Z";
	
	@Mock private DateTimeFormatter mockDateTimeFormatter;
	@Mock private ReadableDateTime mockDateTime;
	
	private DateTimeAdapter dateTimeAdapter;
	
	@Before
	public void setup() {
		dateTimeAdapter = new DateTimeAdapter(mockDateTimeFormatter);
	}
	
	@Test
	public void dateTimeIsWrittenAsString() {
		when(mockDateTimeFormatter.format(mockDateTime)).thenReturn(DATE_STRING);
		assertThat(dateTimeAdapter.marshal(mockDateTime), equalTo(DATE_STRING));
	}
	
	@Test
	public void nullDateTimeIsWrittenAsEmptyString() {
		assertThat(dateTimeAdapter.marshal(null), equalTo(EMPTY));
		verifyZeroInteractions(mockDateTimeFormatter);
	}
	
	@Test
	public void dateTimeIsInflatedFromString() {
		when(mockDateTimeFormatter.parseDateTime(DATE_STRING)).thenReturn(mockDateTime);
		assertThat(dateTimeAdapter.unmarshal(DATE_STRING).toString(), is(DATE_STRING));
	}
	
	@Test
	public void nullIsReturnedFromNullString() {
		assertThat(dateTimeAdapter.unmarshal(null), equalTo(null));
		verifyZeroInteractions(mockDateTimeFormatter);
	}
	
	@Test
	public void nullIsReturnedFromEmptyString() {
		assertThat(dateTimeAdapter.unmarshal(EMPTY), equalTo(null));
		verifyZeroInteractions(mockDateTimeFormatter);
	}
	
	@Test
	public void nullIsReturnedFromWhiteSpaceString() {
		assertThat(dateTimeAdapter.unmarshal("   "), equalTo(null));
		verifyZeroInteractions(mockDateTimeFormatter);
	}

}
