package com.ft.api.ucm.model.v1;

import static net.obvj.junit.utils.matchers.AdvancedMatchers.throwsException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

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
    assertThat(
        () -> new ArticleEntity(null, API_URL), throwsException(IllegalArgumentException.class));
  }

  @Test
  public void exceptionThrownWhenApiUrlIsNull() {
    assertThat(
        () -> new ArticleEntity(UUID, null), throwsException(IllegalArgumentException.class));
  }

  @Test
  public void articleIsCreated() {
    assertThat(instance.getApiUrl(), equalTo(API_URL));
    assertThat(instance.getId(), equalTo(UUID));
  }

  @Test
  public void twoArticlesAreEqualIfTheyAreTheSame() {
    Article another = instance;
    assertThat(another, equalTo(instance));
    assertThat(another.hashCode(), is(instance.hashCode()));
  }

  @Test
  public void twoArticlesAreNotEqualIfOneIsNull() {
    Article another = null;
    assertThat(another, not(equalTo(instance)));
  }

  @Test
  public void twoDifferentArticlesAreNotEqual() {
    Article another = new ArticleEntity(ANOTHER_UUID, API_URL);
    assertThat(another, not(equalTo(instance)));
  }
}
