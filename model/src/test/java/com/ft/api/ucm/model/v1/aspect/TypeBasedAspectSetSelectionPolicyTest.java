package com.ft.api.ucm.model.v1.aspect;

import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.api.ucm.model.v1.ArticleEntity;
import com.ft.api.ucm.model.v1.BlogPostEntity;
import com.ft.api.ucm.model.v1.ContentEntity;
import com.ft.api.ucm.model.v1.SlideshowArticleEntity;

@RunWith(MockitoJUnitRunner.class)
public class TypeBasedAspectSetSelectionPolicyTest {


    @Mock private Set<AspectSet> mockAspectSets;
	@Mock private AspectSet article;
	@Mock private AspectSet slideshow;
	@Mock private AspectSet blogpost;
	@Mock private AspectSet defaultSet;

    private static final String ARTICLE_CLASS_NAME = "com.ft.api.ucm.model.v1.ArticleEntity";
    private static final String SS_ARTICLE_CLASS_NAME = "com.ft.api.ucm.model.v1.SlideshowArticleEntity";
    private static final String BLOGPOST_CLASS_NAME = "com.ft.api.ucm.model.v1.BlogPostEntity";
    private Map<String,AspectSet> aspectSetMap;
	private TypeBasedAspectSetSelectionPolicy instance;

    @Before
    public void setUp() throws Exception {
        aspectSetMap = new HashMap<String,AspectSet>();
        aspectSetMap.put(ARTICLE_CLASS_NAME, article);
        aspectSetMap.put(SS_ARTICLE_CLASS_NAME , slideshow);
        aspectSetMap.put(BLOGPOST_CLASS_NAME , blogpost);
        aspectSetMap.put("default", defaultSet);
        instance = new TypeBasedAspectSetSelectionPolicy(defaultSet,aspectSetMap);
    }

    @Test
	public void shouldThrowExceptionIfAspectSetsIsNull() {
		try{
            instance.match(null, SlideshowArticleEntity.class);
            fail("Should throw IllegalArgumentException");
        }
        catch(IllegalArgumentException iae){
            assertThat("aspectSet is null", iae.getMessage(), equalTo("aspectSets cannot be null"));
        }

	}

    @Test
	public void shouldThrowExceptionIfClassIsNull() {
		try{
            instance.match(mockAspectSets , null);
            fail("Should throw IllegalArgumentException");
        }
        catch(IllegalArgumentException iae){
            assertThat("type is null", iae.getMessage(), equalTo("type cannot be null"));
        }
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
