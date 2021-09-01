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
    assertThat(instance.getApiUrl(), equalTo(API_URL));
    assertThat(instance.getId(), equalTo(UUID));
  }

  @Test
  public void twoBlogsAreEqualIfTheyAreTheSame() {
    BlogPost another = instance;
    assertThat(another, equalTo(instance));
    assertThat(another.hashCode(), is(instance.hashCode()));
  }

  @Test
  public void twoBlogsAreNotEqualIfOneIsNull() {
    BlogPost another = null;
    assertThat(another, not(equalTo(instance)));
  }

  @Test
  public void twoDifferentBlogsAreNotEqual() {
    BlogPost another = new BlogPostEntity(ANOTHER_UUID, API_URL);
    assertThat(another, not(equalTo(instance)));
  }
}
