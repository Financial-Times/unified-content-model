package com.ft.unifiedContentModel.model.aspect;

import java.util.Set;

import com.ft.unifiedContentModel.model.AspectSetAware;

interface AspectSetSelectionPolicy {
	
	AspectSet match(Set<AspectSet> aspectSets, Class<? extends AspectSetAware> type);

}
