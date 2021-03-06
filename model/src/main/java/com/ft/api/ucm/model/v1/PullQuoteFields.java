package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"body", "attribution "})
public class PullQuoteFields {

    private String body;
    private String attribution;
    
    public PullQuoteFields() {}
    
    public PullQuoteFields(String body, String attribution) {
        this.body = body;
        this.attribution = attribution;
    }
    
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }
}
