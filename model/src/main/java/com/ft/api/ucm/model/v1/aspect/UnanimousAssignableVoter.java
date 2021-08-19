package com.ft.api.ucm.model.v1.aspect;

import java.util.Set;

/**
 * An AssignableVoter implementation that requires all Assignables to be supported on a supplied
 * Object for it to be pass a vote.
 */
public class UnanimousAssignableVoter implements AssignableVoter {

  @Override
  public boolean vote(Set<? extends Assignable> assignables, Object object) {
    return canObjectBeAssignedByAll(assignables, object);
  }

  private boolean canObjectBeAssignedByAll(Set<? extends Assignable> assignables, Object object) {
    for (Assignable assignable : assignables) {
      if (!assignable.assignableFrom(object)) {
        return false;
      }
    }
    return true;
  }
}
