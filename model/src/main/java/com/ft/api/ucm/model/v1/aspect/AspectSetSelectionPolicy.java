package com.ft.api.ucm.model.v1.aspect;

import com.ft.api.ucm.model.v1.AspectSetAware;
import java.util.Set;

interface AspectSetSelectionPolicy {

  AspectSet match(Set<AspectSet> aspectSets, Class<? extends AspectSetAware> type);
}
