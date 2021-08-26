package com.ft.api.ucm.model.v1.aspect;

import java.util.Set;

/**
 * An AssignableVoter is responsible for deciding on whether the supplied Object can be assigned to
 * the supplied set of assignables.
 */
public interface AssignableVoter {

  boolean vote(Set<? extends Assignable> assignables, Object object);
}
