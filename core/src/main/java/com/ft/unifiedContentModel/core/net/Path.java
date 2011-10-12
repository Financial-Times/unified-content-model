package com.ft.unifiedContentModel.core.net;

import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.util.Assert;
import org.springframework.web.util.UriTemplate;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

public class Path {

    private final String uri;

    public Path(String uri) {
        this.uri = uri;
    }
    
    private Path(Builder builder) {
    	this.uri = builder.uri;
    }
    
    public static class Builder {
    	
        private String uri;
	    private Map<String, String> vars = Maps.newHashMap();
	    
		public Builder() {}

		public Builder(String uri) {
	    	this.uri = uri;
	    }
	    
	    public Builder withVar(String name, Object value) {
	    	vars.put(name, ObjectUtils.toString(value));
	        return this;
	    }

	    public Builder withVars(Map<String, Object> vars) {
	    	Assert.notEmpty(vars);
	    	this.vars = Maps.transformValues(vars, new Function<Object, String>() {
				@Override public String apply(Object input) {
					return ObjectUtils.toString(input);
				}
			});
	        return this;
	    }

	    public Path build() {
	    	uri = expandPathVariables();
	    	return new Path(this);
	    }
	    
	    private String expandPathVariables() {
	        UriTemplate template = new UriTemplate(uri);
	        return template.expand(vars).toString();
	    }
	    
	  }

    public String getUri() {
        return uri;
    }
    
    @Override
    public String toString() {
    	return getUri();
    }

}
