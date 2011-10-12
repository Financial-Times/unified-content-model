package com.ft.unifiedContentModel.core.net;

import java.util.Map;

public interface PathFactory {
	
	Path createPath(String uri);
	
	Path createPath(String uri, Map<String, Object> vars);

}
