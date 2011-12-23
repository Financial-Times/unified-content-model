package com.ft.unifiedContentModel.ws.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ft.unifiedContentModel.core.log.SupportLogger;
import com.ft.unifiedContentModel.core.log.SystemSupportLogger;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * A {@link Filter} that decorates the {@link HttpServletResponse} to supportLogger sent HTTP errors.
 * 
 * @author andrew.winter
 */
public class HttpErrorStatusLoggingFilter extends OncePerRequestFilter {

    private SupportLogger supportLogger;

    public HttpErrorStatusLoggingFilter() {
        supportLogger = new SystemSupportLogger(HttpErrorStatusLoggingFilter.class);
    }

    public HttpErrorStatusLoggingFilter(SupportLogger supportLogger) {
        this.supportLogger = supportLogger;
    }

    @Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		HttpErrorStatusLoggingResponseWrapper wrapper = new HttpErrorStatusLoggingResponseWrapper(response, request, supportLogger);
		filterChain.doFilter(request, wrapper);
	}

	static class HttpErrorStatusLoggingResponseWrapper extends HttpServletResponseWrapper {
       private HttpServletRequest request;
       private SupportLogger supportLogger;

       HttpErrorStatusLoggingResponseWrapper(HttpServletResponse response, HttpServletRequest request, SupportLogger supportLogger) {
           super(response);
           this.request = request;
           this.supportLogger = supportLogger;
       }

       @Override
       public void setStatus(int sc, String sm) {
    	   if (isStatusError(sc)) {
			   supportLogger.error(createLogMessage(sc, sm));
    	   }
           super.setStatus(sc, sm);
       }

       private boolean isStatusError(int sc) {
    	  HttpStatus.Series series = HttpStatus.valueOf(sc).series();
    	  return (series == HttpStatus.Series.CLIENT_ERROR) || (series == HttpStatus.Series.SERVER_ERROR);
       }

       @Override
       public void setStatus(int sc) {
    	  this.setStatus(sc, null);
       }

       @Override
       public void sendError(int errorCode, String errorMessage) throws IOException {
		   supportLogger.error(createLogMessage(errorCode, errorMessage));
		   super.setStatus(errorCode, errorMessage);
       }	 
       
       @Override
       public void sendError(int errorCode) throws IOException {
    	   this.sendError(errorCode, null);
       }
       
       private String createLogMessage(int errorCode, String errorMessage) {
   		return new StringBuilder("[")
   			   .append("errorCode=")
   			   .append(errorCode).append(", ")
   			   .append("errorMessage=")
   			   .append(errorMessage).append(", ")
   			   .append("url=")
   			   .append(request.getRequestURI()).append(", ")
   			   .append("queryString=")
   			   .append(request.getQueryString()).append(", ")
   			   .append("IP=")
   			   .append(request.getRemoteAddr()).append(", ")
   			   .append("headers=")
   			   .append(getRequestHeaderMap())
   			   .append("]")
   			   .toString();
       }
       
       /** Return an unmodifiable Map that contains all request headers.*/
       @SuppressWarnings("unchecked")
       private Map<String, Collection<String>> getRequestHeaderMap() {
    	   Map<String, Collection<String>> headers = null;
    	   if (request != null) {
    		   Multimap<String, String> headersMap = ArrayListMultimap.create();
    		   Collection<String> headerNames = Collections.list(request.getHeaderNames());
    		   for (String headerName : headerNames) {
    			   Collection<String> headerValues = Collections.list(request.getHeaders(headerName));
    			   for (String headerValue : headerValues) { 
    				   headersMap.put(headerName, headerValue);
    			   }
    		   }
    		   headers = Collections.unmodifiableMap(headersMap.asMap());
    	   }
    	   return headers;
 	  }
   }
}
