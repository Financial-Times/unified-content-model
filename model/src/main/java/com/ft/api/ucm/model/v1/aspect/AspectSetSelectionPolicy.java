package com.ft.api.ucm.model.v1.aspect;

import java.util.Set;

import com.ft.api.ucm.model.v1.AspectSetAware;

interface AspectSetSelectionPolicy {
	
	AspectSet match(Set<AspectSet> aspectSets, Class<? extends AspectSetAware> type);

}
