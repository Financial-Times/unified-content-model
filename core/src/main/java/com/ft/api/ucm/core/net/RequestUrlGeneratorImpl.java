package com.ft.api.ucm.core.net;

import static com.google.common.collect.Iterables.filter;

import java.util.Set;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

public class RequestUrlGeneratorImpl implements RequestUrlGenerator {

    private static final String API_KEY_PARAM_NAME = "apiKey";

    private String baseApiUrl;
	private Set<String> blacklistedParameters = Sets.newHashSet();
	
	public RequestUrlGeneratorImpl(String baseApiUrl) {
		this.baseApiUrl = baseApiUrl;
		addBlacklistedParameter(API_KEY_PARAM_NAME);
	}
	
	@Override
	public String createRequestUrl(String servletPath, String pathInfo, String queryString) {
		return createRequestUrl(HttpProtocol.HTTP, servletPath, pathInfo, queryString);
	}
    
	@Override
	public String createRequestUrl(HttpProtocol httpProtocol, String servletPath, String pathInfo, String queryString) {
	        
        String generatedUrl = UrlBuilder.basedOn(baseApiUrl)
                                    .withPath(servletPath)
                                    .withPathInfo(pathInfo)
                                    .withQueryString(removeBlacklistedParameters(queryString))
                                    .build();
        
        return alignProtocol(generatedUrl, httpProtocol);
    }

    private String removeBlacklistedParameters(String queryString) {
    	if (queryString == null) {
    		return null;
    	}

    	Iterable<String> params = Splitter.on("&").split(queryString);
		Iterable<String> filteredParams = filter(params, startsWithAnyOf(blacklistedParameters));
		return Joiner.on("&").join(filteredParams);
	}

    private Predicate<String> startsWithAnyOf(final Set<String> parameterNames) {
        return new Predicate<String>() {
            public boolean apply(String s) {
                return !Iterables.any(parameterNames, isPrefixOf(s));
            }
        };
    }

    private Predicate<String> isPrefixOf(final String string){
        return new Predicate<String>() {
            public boolean apply(String candidate) {
                return string.startsWith(candidate);
            }
        };
    }

	private String alignProtocol(String baseApiUrl, HttpProtocol httpProtocol) {
        switch(httpProtocol) {
            case HTTPS: 
            	return baseApiUrl.replace("http", httpProtocol.getValue());
            default: 
            	return baseApiUrl;
        }
    }

	public void addBlacklistedParameter(String parameterName) {
		blacklistedParameters.add(parameterName + "=");		
	}
}
