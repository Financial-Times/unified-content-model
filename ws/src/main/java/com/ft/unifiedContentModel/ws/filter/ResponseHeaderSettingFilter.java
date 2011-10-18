package com.ft.unifiedContentModel.ws.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ft.unifiedContentModel.ws.http.ResponseHeader;
import com.google.common.collect.ImmutableList;

/**
 * <p>A Servlet Filter configured with a list of {@link ResponseHeader} objects which are
 * applied to any {@link HttpServletResponse} mapped to this Filter.</p>
 *
 * @author andrew.winter
 */
public class ResponseHeaderSettingFilter extends OncePerRequestFilter {
	
	private static final Log log = LogFactory.getLog(ResponseHeaderSettingFilter.class);

	private List<ResponseHeader> responseHeaders;
	
	public ResponseHeaderSettingFilter(List<ResponseHeader> responseHeaders) {
		Assert.notEmpty(responseHeaders);
		this.responseHeaders = ImmutableList.copyOf(responseHeaders);
	}

	@Override
	protected final void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		response = new ResponseHeaderLoggingResponseWrapper(response);
		filterChain.doFilter(request, response);
		for (ResponseHeader responseHeader : responseHeaders) {
			responseHeader.setOn(response);
		}
	}
	
	private static class ResponseHeaderLoggingResponseWrapper extends HttpServletResponseWrapper {

		public ResponseHeaderLoggingResponseWrapper(HttpServletResponse response) {
			super(response);
		}
		@Override 
		public void setHeader(String name, String value) {
			logHeaderAddition(name, value);
            super.setHeader(name, value);
        }
        @Override 
        public void addHeader(String name, String value) {
			logHeaderAddition(name, value);
            super.addHeader(name, value);
        }
        
        private void logHeaderAddition(String name, String value) {
        	if (log.isDebugEnabled()) {
            	log.debug("Adding response header [" + name + " : " + value + "]");
            }
        }	
	}	
}
