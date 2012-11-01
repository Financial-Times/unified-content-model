package com.ft.api.ucm.v1.model.aspect;

import java.util.Set;

import com.ft.api.ucm.v1.model.AspectSetAware;

interface AspectSetSelectionPolicy {
	
	AspectSet match(Set<AspectSet> aspectSets, Class<? extends AspectSetAware> type);

}
