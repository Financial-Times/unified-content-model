package com.ft.api.ucm.core.net;

public enum HttpProtocol {
    
    HTTP("http"), HTTPS("https");
    
    private HttpProtocol(String protocol){
        this.protocol = protocol;
    }

    private String protocol;
    
    public String getValue(){
        return protocol;
    }
    
    public static HttpProtocol fromString(String protocol) {
        if (protocol != null) {
          for (HttpProtocol httpProtocol : HttpProtocol.values()) {
            if (protocol.equalsIgnoreCase(httpProtocol.protocol)) {
              return httpProtocol;
            }
          }
        }
        return null;
      }
}
