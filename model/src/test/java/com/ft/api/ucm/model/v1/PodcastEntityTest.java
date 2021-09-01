package com.ft.api.ucm.model.v1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PodcastEntityTest {

  private static final String UUID = "123";
  private static final String API_URL = "api-url";
  private static final String ANOTHER_UUID = "123-456-789";

  private PodcastEntity instance;

  @BeforeEach
  public void setUp() {
    instance = new PodcastEntity(UUID, API_URL);
  }

  @Test
  public void exceptionThrownWhenIdIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new PodcastEntity(null, API_URL));
  }

  @Test
  public void podcastIsCreated() {
    assertThat(instance.getId(), equalTo(UUID));
  }

  @Test
  public void twoPodcastsAreEqualIfTheyAreTheSame() {
    Podcast another = instance;
    assertThat(instance, equalTo(another));
    assertThat(instance.hashCode(), is(another.hashCode()));
  }

  @Test
  public void twoPodcastsAreNotEqualIfOneIsNull() {
    Podcast another = null;
    assertThat(instance, not(equalTo(another)));
  }

  @Test
  public void twoDifferentPodcastsAreNotEqual() {
    Podcast another = new PodcastEntity(ANOTHER_UUID, API_URL);
    assertThat(instance, not(equalTo(another)));
  }
}
