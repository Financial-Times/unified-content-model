package com.ft.api.ucm.model.v1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BlogPostEntityTest {

  private static final String API_URL = "http://apiUrl.com/example";
  private static final String UUID = "123";
  private static final String ANOTHER_UUID = "123-456-789";

  private BlogPostEntity instance;

  @BeforeEach
  public void setUp() {
    instance = new BlogPostEntity(UUID, API_URL);
  }

  @Test
  public void exceptionThrownWhenIdIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new BlogPostEntity(null, API_URL));
  }

  @Test
  public void exceptionNOThrownWhenApiUrlIsNull() {
    new BlogPostEntity(UUID, null);
  }

  @Test
  public void blogIsCreated() {
    assertThat(API_URL, equalTo(instance.getApiUrl()));
    assertThat(UUID, equalTo(instance.getId()));
  }

  @Test
  public void twoBlogsAreEqualIfTheyAreTheSame() {
    BlogPost another = instance;
    assertThat(instance, equalTo(another));
    assertThat(instance.hashCode(), is(another.hashCode()));
  }

  @Test
  public void twoBlogsAreNotEqualIfOneIsNull() {
    BlogPost another = null;
    assertThat(instance, not(equalTo(another)));
  }

  @Test
  public void twoDifferentBlogsAreNotEqual() {
    BlogPost another = new BlogPostEntity(ANOTHER_UUID, API_URL);
    assertThat(instance, not(equalTo(another)));
  }
}
