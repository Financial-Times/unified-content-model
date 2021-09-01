package com.ft.api.ucm.model.v1;

import static net.obvj.junit.utils.matchers.AdvancedMatchers.throwsException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PageEntityTest {

  private static final String UUID = "123";
  private static final String API_URL = "api-url";
  private static final String ANOTHER_UUID = "123-456-789";

  private PageEntity instance;

  @BeforeEach
  public void setUp() {
    instance = new PageEntity(UUID, API_URL);
  }

  @Test
  public void exceptionThrownWhenIdIsNull() {
    assertThat(
        () -> new PageEntity(null, API_URL), throwsException(IllegalArgumentException.class));
  }

  @Test
  public void isCreated() {
    assertThat(instance.getId(), equalTo(UUID));
  }

  @Test
  public void twoAreEqualIfTheyAreTheSame() {
    Page another = instance;
    assertThat(instance, equalTo(another));
    assertThat(instance.hashCode(), is(another.hashCode()));
  }

  @Test
  public void twoAreNotEqualIfOneIsNull() {
    Page another = null;
    assertThat(instance, not(equalTo(another)));
  }

  @Test
  public void twoDifferentAreNotEqual() {
    Page another = new PageEntity(ANOTHER_UUID, API_URL);
    assertThat(instance, not(equalTo(another)));
  }
}
