package com.ft.api.ucm.core.net;

public class RequestUrlGeneratorImpl implements RequestUrlGenerator {

    private static final String HTTP = "http";
    private String baseApiUrl;
	
	public RequestUrlGeneratorImpl(String baseApiUrl) {
		this.baseApiUrl = baseApiUrl;
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
                                        .withQueryString(queryString)
                                        .build();
	        
	        return alignProtocol(generatedUrl, httpProtocol);
        }

    private String alignProtocol(String baseApiUrl, HttpProtocol httpProtocol) {
        switch(httpProtocol) {
            case HTTPS: return baseApiUrl.replace(HTTP, httpProtocol.getValue());
            default: return baseApiUrl;
        }
    }
}
