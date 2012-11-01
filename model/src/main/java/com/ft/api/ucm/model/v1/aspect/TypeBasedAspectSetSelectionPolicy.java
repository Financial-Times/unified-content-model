package com.ft.api.ucm.model.v1.aspect;


import static org.springframework.util.Assert.notNull;

import com.ft.api.ucm.model.v1.AspectSetAware;

import java.util.Map;
import java.util.Set;

public class TypeBasedAspectSetSelectionPolicy implements AspectSetSelectionPolicy {

    private Map<String, AspectSet> aspectSetMap;
    private AspectSet defaultAspectSet;

    public TypeBasedAspectSetSelectionPolicy(AspectSet aspectSet, Map<String, AspectSet> aspectSetMap) {
        defaultAspectSet = aspectSet;
        this.aspectSetMap = aspectSetMap;
    }

    @Override
    public AspectSet match(Set<AspectSet> aspectSets, Class<? extends AspectSetAware> type) {
        notNull(aspectSets,"aspectSets cannot be null");
        notNull(type,"type cannot be null");
        AspectSet aspectSet =   aspectSetMap.get(type.getName());
        if(aspectSet == null){
            return defaultAspectSet;
        }
        return aspectSet;
    }
}
