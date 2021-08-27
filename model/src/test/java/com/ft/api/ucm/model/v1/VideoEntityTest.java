package com.ft.api.ucm.model.v1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VideoEntityTest {

  private static final String UUID = "123";
  private static final String API_URL = "api-url";
  private static final String ANOTHER_UUID = "123-456-789";

  private VideoEntity instance;

  @BeforeEach
  public void setUp() {
    instance = new VideoEntity(UUID, API_URL);
  }

  @Test
  public void exceptionThrownWhenIdIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new VideoEntity(null, API_URL));
  }

  @Test
  public void videoIsCreated() {
    assertThat(UUID, equalTo(instance.getId()));
  }

  @Test
  public void twoVideosAreEqualIfTheyAreTheSame() {
    Video another = instance;
    assertThat(instance, equalTo(another));
    assertThat(instance.hashCode(), is(another.hashCode()));
  }

  @Test
  public void twoVideosAreNotEqualIfOneIsNull() {
    Video another = null;
    assertThat(instance, not(equalTo(another)));
  }

  @Test
  public void twoDifferentVideosAreNotEqual() {
    Video another = new VideoEntity(ANOTHER_UUID, API_URL);
    assertThat(instance, not(equalTo(another)));
  }
}
