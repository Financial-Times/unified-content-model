package com.ft.api.ucm.model.v1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArticleEntityTest {

  private static final String API_URL = "http://apiUrl.com/example";
  private static final String UUID = "123";
  private static final String ANOTHER_UUID = "123-456-789";

  private ArticleEntity instance;

  @BeforeEach
  public void setUp() {
    instance = new ArticleEntity(UUID, API_URL);
  }

  @Test
  public void exceptionThrownWhenIdIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new ArticleEntity(null, API_URL));
  }

  @Test
  public void exceptionThrownWhenApiUrlIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new ArticleEntity(UUID, null));
  }

  @Test
  public void articleIsCreated() {
    assertThat(API_URL, equalTo(instance.getApiUrl()));
    assertThat(UUID, equalTo(instance.getId()));
  }

  @Test
  public void twoArticlesAreEqualIfTheyAreTheSame() {
    Article another = instance;
    assertThat(instance, equalTo(another));
    assertThat(instance.hashCode(), is(another.hashCode()));
  }

  @Test
  public void twoArticlesAreNotEqualIfOneIsNull() {
    Article another = null;
    assertThat(instance, not(equalTo(another)));
  }

  @Test
  public void twoDifferentArticlesAreNotEqual() {
    Article another = new ArticleEntity(ANOTHER_UUID, API_URL);
    assertThat(instance, not(equalTo(another)));
  }
}
