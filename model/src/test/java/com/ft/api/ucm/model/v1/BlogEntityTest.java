package com.ft.api.ucm.model.v1;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.ft.api.ucm.model.v1.Blog;
import com.ft.api.ucm.model.v1.BlogEntity;

public class BlogEntityTest {
	
	private static final String API_URL = "http://apiUrl.com/example";
	private static final String UUID = "123";
	private static final String ANOTHER_UUID = "123-456-789";
	
	private BlogEntity instance;
	
	@Before
	public void setUp() {
		instance = new BlogEntity(UUID, API_URL);
	}

	@Test(expected=IllegalArgumentException.class)
	public void exceptionThrownWhenIdIsNull() {
		new BlogEntity(null, API_URL);
	}
	
	@Test
	public void exceptionNOThrownWhenApiUrlIsNull() {
		new BlogEntity(UUID, null);
	}

	@Test
	public void blogIsCreated() {
		assertEquals(API_URL, instance.getApiUrl());
		assertEquals(UUID, instance.getId());
	}
	
	@Test
	public void twoBlogsAreEqualIfTheyAreTheSame() {
		Blog another = instance;
		assertThat(instance, equalTo(another));
		assertThat(instance.hashCode(), is(another.hashCode()));
	}
	
	@Test
	public void twoBlogsAreNotEqualIfOneIsNull() {
		Blog another = null;
		assertThat(instance, not(equalTo(another)));
	}
	
	@Test
	public void twoDifferentBlogsAreNotEqual() {
		Blog another = new BlogEntity(ANOTHER_UUID, API_URL);
		assertThat(instance, not(equalTo(another)));
	}
}
