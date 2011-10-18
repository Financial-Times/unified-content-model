package com.ft.unifiedContentModel.ws.http;

import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.unifiedContentModel.ws.http.PragmaResponseHeader;

@RunWith(MockitoJUnitRunner.class)
public class PragmaResponseHeaderTest {
	
	private PragmaResponseHeader header;
	

	@Mock 
	private HttpServletResponse mockResponse;
	
	@Before
	public void setup(){
		header = new PragmaResponseHeader();
	}
	
	@Test
	public void pragmaSetOnResponse(){
		header.setOn(mockResponse);
		verify(mockResponse).addHeader(PragmaResponseHeader.PRAGMA_HEADER_NAME, PragmaResponseHeader.PRAGMA_HEADER_VALUE);
	}

}
