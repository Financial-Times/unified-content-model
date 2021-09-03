package com.ft.api.ucm.model.v1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringBasedBodyTest {

  private static final String TEXT = "The quick brown fox jumps over the lazy dog";
  private static final String MEDIA_TYPE = "test/html";

  private StringBasedBody instance;

  @BeforeEach
  public void setUp() {
    instance = new StringBasedBody(TEXT, MEDIA_TYPE);
  }

  @Test
  public void bodyTextEmptyIfConstructorArgIsNull() {
    instance = new StringBasedBody(null, null);
    assertThat(instance.toString(), nullValue());
  }

  @Test
  public void equalIfTheyAreTheSame() {
    Body another = instance;
    assertThat(another, equalTo(instance));
    assertThat(another.hashCode(), is(instance.hashCode()));
  }

  @Test
  public void notEqualIfOneIsNull() {
    Body another = null;
    assertThat(another, not(equalTo(instance)));
  }

  @Test
  public void twoDifferentInstancesAreNotEqual() {
    Body another = new StringBasedBody("I AM NOT A FOX OR A DOG", MEDIA_TYPE);
    assertThat(another, not(equalTo(instance)));
  }
}
