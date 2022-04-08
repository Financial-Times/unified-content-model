package com.ft.api.ucm.model.v1.aspect;

import static org.springframework.util.Assert.notNull;

import com.ft.api.ucm.model.v1.AspectSetAware;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Set;

public final class ImmutableAspectSet implements AspectSet {

  private static final class ApplyAspectSetFunction implements Function<Aspect, String> {
    @Override
    public String apply(Aspect input) {
      return input.toString();
    }
  }

  private AssignableVoter assignableVoter;
  private NamedNode<Aspect> namedNode;

  private ImmutableAspectSet(String name, Set<Aspect> aspects, AssignableVoter assignableVoter) {
    notNull(assignableVoter, "assignableVoter should not be null");
    namedNode = new NamedNode<Aspect>(name, aspects);
    this.assignableVoter = assignableVoter;
  }

  public static ImmutableAspectSet valueOf(
      String name, Set<Aspect> aspects, AssignableVoter assignableVoter) {
    return new ImmutableAspectSet(name, aspects, assignableVoter);
  }

  @Override
  public void applyTo(AspectSetAware aspectSetAware) {
    aspectSetAware.setAspectSet(toString());
    aspectSetAware.setAspects(
        Lists.newArrayList(
            Iterables.transform(namedNode.getChildren(), new ApplyAspectSetFunction())));
  }

  @Override
  public boolean assignableFrom(Object object) {
    return assignableVoter.vote(namedNode.getChildren(), object);
  }

  @Override
  public boolean equals(Object that) {
    if (!(that instanceof ImmutableAspectSet)) {
      return false;
    }
    ImmutableAspectSet thatAspectSet = (ImmutableAspectSet) that;
    return namedNode.equals(thatAspectSet.namedNode);
  }

  @Override
  public int hashCode() {
    return namedNode.hashCode();
  }

  @Override
  public String toString() {
    return namedNode.toString();
  }

  @Override
  public int compareTo(AspectSet that) {
    return toString().compareTo(that.toString());
  }
}
