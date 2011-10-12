package com.ft.unifiedContentModel.core.net;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Url {

    private String url;

    public Url() {
    	
    }
    
    /**
     * Create a new Url object from a String.
     * 
     * @throws IllegalArgumentException if the String is not a valid Url pattern.
     */
    public Url(String url) {
    	URI.create(url);
        this.url = url;
    }
    
    /**
     * Create a Url appending another Url to the current one
     * 
     * @param url to append
     * @return
     */
	public Url append(Url url) {
		return new Url(new StringBuilder(this.toString())
				.append(url.toString()).toString());
	}
    
    /**
     * This is more expensive than just returning a String, as a domain name
     * lookup is used to verify the URL. Only use this where necessary.
     * 
     * @throws IllegalStateException if the Url is not valid.
     */
    public URL toUrl() {
    	try {
			return new URL(url);
		} catch (MalformedURLException e) {
			throw new IllegalStateException(e);
		}
    }

    
    @Override
    public String toString() {
    	return url;
    }

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
}
