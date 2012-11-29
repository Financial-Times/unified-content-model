package com.ft.api.ucm.model.v1.items.urls;

public enum HttpProtocol {
    
    HTTP("http"), HTTPS("https");
    
    private HttpProtocol(String value){
        this.value = value;
    }

    private String value;
    
    public String getValue(){
        return value;
    }
}
