package com.ft.api.ucm.model.v1.aspect;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

public class NamedNodeTest {

  private static final String NAME = "NAME";
  private static final String A = "A";
  private static final String B = "B";
  private static final String C = "C";

  private NamedNode<String> instance;

  @Test
  public void constructWithNullNameRaisesException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new NamedNode<String>(null, Sets.<String>newHashSet()));
  }

  @Test
  public void constructWithNullChildrenRaisesException() {
    assertThrows(IllegalArgumentException.class, () -> new NamedNode<String>(NAME, null));
  }

  @Test
  public void constructorSortsChildSet() {
    instance = new NamedNode<String>(NAME, Sets.newHashSet(C, B, A));
    assertThat(instance.getChildren(), equalTo(Sets.newTreeSet(Sets.newHashSet(C, B, A))));
  }

  @Test
  public void toStringReturnsName() {
    instance = new NamedNode<String>(NAME, Sets.newHashSet(A, B, C));
    assertThat(instance, hasToString(equalTo(NAME)));
  }

  @Test
  public void equal() {
    instance = new NamedNode<String>(NAME, Sets.newHashSet(A, B, C));
    NamedNode<String> anotherInstance = new NamedNode<String>(NAME, Sets.newHashSet(A, B, C));
    assertThat(instance, equalTo(instance));
    assertThat(anotherInstance, equalTo(instance));
    assertThat(instance.hashCode(), equalTo(anotherInstance.hashCode()));
  }

  @Test
  public void notEqual() {
    instance = new NamedNode<String>(NAME, Sets.newHashSet(A, B, C));
    NamedNode<String> anotherInstance = new NamedNode<String>(NAME + "2", Sets.newHashSet(A, B, C));
    assertThat(instance.equals(null), is(false));
    assertThat(instance.equals(anotherInstance), is(false));
    assertThat(instance.hashCode() == anotherInstance.hashCode(), is(false));
  }
}
