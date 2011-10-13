package com.ft.unifiedContentModel.model;

import java.util.List;

public interface AspectSetAware {
	
	void setAspectSet(String aspectSetName);
	void setAspects(List<String> aspectNames);

}
