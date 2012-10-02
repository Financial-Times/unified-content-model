package com.ft.unifiedContentModel.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.ft.unifiedContentModel.model.Video;
import com.ft.unifiedContentModel.model.VideoEntity;

public class VideoEntityTest {
	
	private static final String UUID = "123";
	private static final String ANOTHER_UUID = "123-456-789";
	
	private VideoEntity instance;
	
	@Before
	public void setUp() {
		instance = new VideoEntity(UUID);
	}

	@Test(expected=IllegalArgumentException.class)
	public void exceptionThrownWhenIdIsNull() {
		new VideoEntity(null);
	}
	
	@Test
	public void videoIsCreated() {
		assertEquals(UUID, instance.getId());
	}
	
	@Test
	public void twoVideosAreEqualIfTheyAreTheSame() {
		Video another = instance;
		assertThat(instance, equalTo(another));
		assertThat(instance.hashCode(), is(another.hashCode()));
	}
	
	@Test
	public void twoVideosAreNotEqualIfOneIsNull() {
		Video another = null;
		assertThat(instance, not(equalTo(another)));
	}
	
	@Test
	public void twoDifferentVideosAreNotEqual() {
		Video another = new VideoEntity(ANOTHER_UUID);
		assertThat(instance, not(equalTo(another)));
	}
}
