package com.ft.api.ucm.model.v1.aspect;

import static org.springframework.util.Assert.notNull;

import java.util.Set;

public final class ImmutableAspect implements Aspect {

  private AssignableVoter assignableVoter;
  private NamedNode<Field> namedNode;

  private ImmutableAspect(String name, Set<Field> fields, AssignableVoter assignableVoter) {
    notNull(assignableVoter, "assignableVoter should not be null");
    notNull(AspectEnum.getByValue(name), String.format("Unable to find aspect by name %s", name));
    namedNode = new NamedNode<>(name, fields);
    this.assignableVoter = assignableVoter;
  }

  public static ImmutableAspect valueOf(
      String name, Set<Field> fields, AssignableVoter assignableVoter) {
    return new ImmutableAspect(name, fields, assignableVoter);
  }

  @Override
  public boolean assignableFrom(Object object) {
    return assignableVoter.vote(namedNode.getChildren(), object);
  }

  @Override
  public boolean equals(Object that) {
    if (!(that instanceof ImmutableAspect)) {
      return false;
    }
    ImmutableAspect thatAspect = (ImmutableAspect) that;
    return namedNode.equals(thatAspect.namedNode);
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
  public int compareTo(Aspect that) {
    return toString().compareTo(that.toString());
  }
}
