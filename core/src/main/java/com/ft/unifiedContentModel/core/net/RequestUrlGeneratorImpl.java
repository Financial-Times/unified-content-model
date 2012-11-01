package com.ft.unifiedContentModel.core.net;

public class RequestUrlGeneratorImpl implements RequestUrlGenerator {

	private String baseApiUrl;

	public RequestUrlGeneratorImpl(String baseApiUrl) {
		this.baseApiUrl = baseApiUrl;
	}
	@Override
	public String createRequestUrl(String servletPath, String pathInfo, String queryString) {
		return UrlBuilder.basedOn(baseApiUrl)
			.withPath(servletPath)
			.withPathInfo(pathInfo)
			.withQueryString(queryString)
			.build().getUrl();
	}


}
