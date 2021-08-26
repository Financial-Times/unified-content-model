package com.ft.api.ucm.model.v1;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PageEntityTest {

  private static final String UUID = "123";
  private static final String API_URL = "api-url";
  private static final String ANOTHER_UUID = "123-456-789";

  private PageEntity instance;

  @Before
  public void setUp() {
    instance = new PageEntity(UUID, API_URL);
  }

  @Test(expected = IllegalArgumentException.class)
  public void exceptionThrownWhenIdIsNull() {
    new PageEntity(null, API_URL);
  }

  @Test
  public void isCreated() {
    assertEquals(UUID, instance.getId());
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
