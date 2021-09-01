package com.ft.api.ucm.model.v1.aspect;

import static net.obvj.junit.utils.matchers.AdvancedMatchers.throwsException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.sameInstance;

import com.ft.api.ucm.model.v1.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TypeBasedAspectSetSelectionPolicyTest {

  @Mock private Set<AspectSet> mockAspectSets;
  @Mock private AspectSet article;
  @Mock private AspectSet slideshow;
  @Mock private AspectSet blogpost;
  @Mock private AspectSet defaultSet;

  private static final String ARTICLE_CLASS_NAME = "com.ft.api.ucm.model.v1.ArticleEntity";
  private static final String SS_ARTICLE_CLASS_NAME =
      "com.ft.api.ucm.model.v1.SlideshowArticleEntity";
  private static final String BLOGPOST_CLASS_NAME = "com.ft.api.ucm.model.v1.BlogPostEntity";
  private Map<String, AspectSet> aspectSetMap;
  private TypeBasedAspectSetSelectionPolicy instance;

  @BeforeEach
  public void setUp() throws Exception {
    aspectSetMap = new HashMap<String, AspectSet>();
    aspectSetMap.put(ARTICLE_CLASS_NAME, article);
    aspectSetMap.put(SS_ARTICLE_CLASS_NAME, slideshow);
    aspectSetMap.put(BLOGPOST_CLASS_NAME, blogpost);
    aspectSetMap.put("default", defaultSet);
    instance = new TypeBasedAspectSetSelectionPolicy(defaultSet, aspectSetMap);
  }

  @Test
  public void shouldThrowExceptionIfAspectSetsIsNull() {
    assertThat(
        "aspectSet is null",
        () -> instance.match(null, SlideshowArticleEntity.class),
        throwsException(IllegalArgumentException.class).withMessage("aspectSets cannot be null"));
  }

  @Test
  public void shouldThrowExceptionIfClassIsNull() {
    assertThat(
        "type is null",
        () -> instance.match(mockAspectSets, null),
        throwsException(IllegalArgumentException.class).withMessage("type cannot be null"));
  }

  @Test
  public void shouldFindArticleAspectSet() throws Exception {
    AspectSet aspectSet = instance.match(mockAspectSets, ArticleEntity.class);
    assertThat("aspectSet is not article", aspectSet, sameInstance(article));
  }

  @Test
  public void shouldFindSlideshowAspectSet() throws Exception {
    AspectSet aspectSet = instance.match(mockAspectSets, SlideshowArticleEntity.class);
    assertThat("aspectSet is not Slideshow", aspectSet, sameInstance(slideshow));
  }

  @Test
  public void shouldFindBlogpostAspectSet() throws Exception {
    AspectSet aspectSet = instance.match(mockAspectSets, BlogPostEntity.class);
    assertThat("aspectSet is not Blogpost", aspectSet, sameInstance(blogpost));
  }

  @Test
  public void shouldFindDefaultAspectSet() throws Exception {
    AspectSet aspectSet = instance.match(mockAspectSets, ContentEntity.class);
    assertThat("aspectSet is not default", aspectSet, sameInstance(defaultSet));
  }
}
