package com.ft.unifiedContentModel.ws.http;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.unifiedContentModel.core.datetime.Clock;

@RunWith(MockitoJUnitRunner.class)
public class LastBuiltResponseHeaderTest {
	
	private static final String UTC_DATE = "2011-10-31T15:03:36.180Z";
		
	@Mock private HttpServletResponse mockResponse;
	@Mock private Clock mockClock;
	
	private LastBuiltResponseHeader instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new LastBuiltResponseHeader(mockClock);
	}

	@Test
	public void dateSetOnResponse() {
		when(mockClock.toString()).thenReturn(UTC_DATE);
		instance.setOn(mockResponse);
		verify(mockResponse).addHeader(LastBuiltResponseHeader.LAST_BUILT_HEADER_NAME, UTC_DATE);
	}
	
}
