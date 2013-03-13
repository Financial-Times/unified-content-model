package com.ft.api.ucm.model.v1;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.ft.api.ucm.model.v1.BlogPost;
import com.ft.api.ucm.model.v1.BlogPostEntity;

public class BlogPostEntityTest {
	
	private static final String API_URL = "http://apiUrl.com/example";
	private static final String UUID = "123";
	private static final String ANOTHER_UUID = "123-456-789";
	
	private BlogPostEntity instance;
	
	@Before
	public void setUp() {
		instance = new BlogPostEntity(UUID, API_URL);
	}

	@Test(expected=IllegalArgumentException.class)
	public void exceptionThrownWhenIdIsNull() {
		new BlogPostEntity(null, API_URL);
	}
	
	@Test
	public void exceptionNOThrownWhenApiUrlIsNull() {
		new BlogPostEntity(UUID, null);
	}

	@Test
	public void blogIsCreated() {
		assertEquals(API_URL, instance.getApiUrl());
		assertEquals(UUID, instance.getId());
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
