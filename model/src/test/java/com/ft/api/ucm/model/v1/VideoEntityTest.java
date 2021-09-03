package com.ft.api.ucm.model.v1;

import static net.obvj.junit.utils.matchers.AdvancedMatchers.throwsException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

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
    assertThat(
        () -> new VideoEntity(null, API_URL), throwsException(IllegalArgumentException.class));
  }

  @Test
  public void videoIsCreated() {
    assertThat(instance.getId(), equalTo(UUID));
  }

  @Test
  public void twoVideosAreEqualIfTheyAreTheSame() {
    Video another = instance;
    assertThat(another, equalTo(instance));
    assertThat(another.hashCode(), is(instance.hashCode()));
  }

  @Test
  public void twoVideosAreNotEqualIfOneIsNull() {
    Video another = null;
    assertThat(another, not(equalTo(instance)));
  }

  @Test
  public void twoDifferentVideosAreNotEqual() {
    Video another = new VideoEntity(ANOTHER_UUID, API_URL);
    assertThat(another, not(equalTo(instance)));
  }
}
