package com.ft.api.ucm.model.v1.aspect;

import static org.springframework.util.Assert.notNull;

import com.ft.api.ucm.model.v1.AspectSetAware;
import com.google.common.base.MoreObjects;
import java.util.Set;

public class PolicyBasedAspectSetCollection implements AspectSetCollection {

  private AspectSetSelectionPolicy aspectSetSelectionPolicy;
  private Set<AspectSet> aspectSets;

  public PolicyBasedAspectSetCollection(
      Set<AspectSet> aspectSets, AspectSetSelectionPolicy aspectSetSelectionPolicy) {
    notNull(aspectSets, "aspectSets should not be null");
    notNull(aspectSetSelectionPolicy, "aspectSetSelectionPolicy should not be null");
    this.aspectSets = aspectSets;
    this.aspectSetSelectionPolicy = aspectSetSelectionPolicy;
  }

  @Override
  public void applyTo(AspectSetAware aspectSetAware) {
    AspectSet aspectSet = getAspectSetByType(aspectSetAware.getClass());
    aspectSet.applyTo(aspectSetAware);
  }

  private AspectSet getAspectSetByType(Class<? extends AspectSetAware> type) {
    return aspectSetSelectionPolicy.match(aspectSets, type);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("aspectSets", aspectSets)
        .add("aspectSetSelectionPolicy", aspectSetSelectionPolicy)
        .toString();
  }
}
