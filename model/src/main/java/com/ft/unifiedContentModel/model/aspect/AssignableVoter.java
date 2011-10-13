package com.ft.unifiedContentModel.model.aspect;

import java.util.Set;

/**
 * <p>An AssignableVoter is responsible for deciding on whether the supplied Object can be 
 * assigned to the supplied set of assignables.</p>
 */
public interface AssignableVoter {
	
	boolean vote(Set<? extends Assignable> assignables, Object object);

}
