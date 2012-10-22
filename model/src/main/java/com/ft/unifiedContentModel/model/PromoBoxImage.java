package com.ft.unifiedContentModel.model;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"url", "type", "height", "width", "alt"})
public class PromoBoxImage {

    private String url;
    private String type;
    private String height;
    private String width;
    private String alt;
    
    public PromoBoxImage() {}
    
    public PromoBoxImage(String url, String type, String height, String width, String alt) {
        this.url = url;
        this.type = type;
        this.height = height;
        this.width = width;
        this.alt = alt;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public String getWidth() {
        return width;
    }
    public void setWidth(String width) {
        this.width = width;
    }
    public String getAlt() {
        return alt;
    }
    public void setAlt(String alt) {
        this.alt = alt;
    }
}
