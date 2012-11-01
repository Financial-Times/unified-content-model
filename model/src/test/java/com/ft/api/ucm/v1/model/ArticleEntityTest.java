package com.ft.api.ucm.v1.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ArticleEntityTest {
	
	private static final String API_URL = "http://apiUrl.com/example";
	private static final String UUID = "123";
	private static final String ANOTHER_UUID = "123-456-789";
	
	private ArticleEntity instance;
	
	@Before
	public void setUp() {
		instance = new ArticleEntity(UUID, API_URL);
	}

	@Test(expected=IllegalArgumentException.class)
	public void exceptionThrownWhenIdIsNull() {
		new ArticleEntity(null, API_URL);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void exceptionThrownWhenApiUrlIsNull() {
		new ArticleEntity(UUID, null);
	}

	@Test
	public void articleIsCreated() {
		assertEquals(API_URL, instance.getApiUrl());
		assertEquals(UUID, instance.getId());
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
