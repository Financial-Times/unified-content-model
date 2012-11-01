package com.ft.api.ucm.rest.http;

import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PragmaResponseHeaderTest {
	
	private PragmaResponseHeader header;
	

	@Mock 
	private HttpServletResponse mockResponse;
	@Mock private HttpServletRequest mockRequest;
	
	@Before
	public void setup(){
		header = new PragmaResponseHeader();
	}
	
	@Test
	public void pragmaSetOnResponse(){
		header.setOn(mockResponse, mockRequest);
		verify(mockResponse).addHeader(PragmaResponseHeader.PRAGMA_HEADER_NAME, PragmaResponseHeader.PRAGMA_HEADER_VALUE);
	}

}
