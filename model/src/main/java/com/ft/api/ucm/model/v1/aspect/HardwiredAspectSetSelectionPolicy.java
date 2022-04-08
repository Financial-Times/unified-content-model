package com.ft.api.ucm.model.v1.aspect;

import com.ft.api.ucm.model.v1.AspectSetAware;
import com.google.common.base.MoreObjects;
import java.util.Set;
import org.springframework.util.Assert;

class HardwiredAspectSetSelectionPolicy implements AspectSetSelectionPolicy {

  private AspectSet defaultAspectSet;

  public HardwiredAspectSetSelectionPolicy(AspectSet defaultAspectSet) {
    Assert.notNull(defaultAspectSet, "defaultAspectSet should not be null");
    this.defaultAspectSet = defaultAspectSet;
  }

  @Override
  public AspectSet match(Set<AspectSet> aspectSets, Class<? extends AspectSetAware> type) {
    return defaultAspectSet;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("defaultAspectSet", defaultAspectSet).toString();
  }
}
