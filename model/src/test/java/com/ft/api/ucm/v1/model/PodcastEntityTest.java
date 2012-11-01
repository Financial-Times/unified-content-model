package com.ft.api.ucm.v1.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PodcastEntityTest {
	
	private static final String UUID = "123";
	private static final String API_URL = "api-url";
	private static final String ANOTHER_UUID = "123-456-789";
	
	private PodcastEntity instance;
	
	@Before
	public void setUp() {
		instance = new PodcastEntity(UUID, API_URL);
	}

	@Test(expected=IllegalArgumentException.class)
	public void exceptionThrownWhenIdIsNull() {
		new PodcastEntity(null, API_URL);
	}

	@Test
	public void podcastIsCreated() {
		assertEquals(UUID, instance.getId());
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
