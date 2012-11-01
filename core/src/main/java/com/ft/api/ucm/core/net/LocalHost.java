package com.ft.api.ucm.core.net;

public class LocalHost implements Host {

	static final String UNKNOWN_HOST = "unknown";
	
	private String hostname;
	
	public LocalHost() {
		try {
			hostname = java.net.InetAddress.getLocalHost().getHostName();
		} catch (java.net.UnknownHostException e) {
			hostname = UNKNOWN_HOST;
		}
	}
	@Override
	public String getHostName() {
		return hostname;
	}
}
