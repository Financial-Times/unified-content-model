package com.ft.unifiedContentModel.testsupport.tools;

import static com.jayway.restassured.RestAssured.get;

import com.ft.unifiedContentModel.core.net.Url;
import com.jayway.restassured.response.Response;

public class RestClient {
	
	public Response getUrl(Url apiUrl) {
		return get(apiUrl.toString());
	}
}
