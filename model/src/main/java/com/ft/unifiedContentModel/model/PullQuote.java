package com.ft.unifiedContentModel.model;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"name", "type", "fields"})
public class PullQuote implements Asset {

    private String name;
    private PullQuoteFields fields;
    private String type;

    public PullQuote() {}
    
    public PullQuote(PullQuoteFields fields, String type) { 
        this.fields = fields;
        this.type = type;
    }
    
    public PullQuoteFields getFields() {
        return fields;
    }

    public void setFields(PullQuoteFields fields) {
        this.fields = fields;
    }

    @Override
    public String getName() {
       return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }
}
