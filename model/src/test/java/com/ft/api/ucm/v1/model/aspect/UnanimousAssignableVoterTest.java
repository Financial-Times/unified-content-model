package com.ft.api.ucm.v1.model.aspect;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Sets;

@RunWith(MockitoJUnitRunner.class)
public class UnanimousAssignableVoterTest {

	@Mock private Assignable assignable;
	@Mock private Assignable anotherAssignable;

	private UnanimousAssignableVoter instance;
	private Set<Assignable> assignables;
	
	@Before
	public void setUp() throws Exception {
		instance = new UnanimousAssignableVoter();
		assignables = Sets.newHashSet(assignable, anotherAssignable);
	}
	
	@Test
	public void voteFailsIfNotAllAssignablesAgree() {
		when(assignable.assignableFrom(any())).thenReturn(false);
		when(anotherAssignable.assignableFrom(any())).thenReturn(true);
		
		assertFalse(instance.vote(assignables, new Object()));
	}
	
	@Test
	public void votePassesIfAllAssignablesAgree() {
		when(assignable.assignableFrom(any())).thenReturn(true);
		when(anotherAssignable.assignableFrom(any())).thenReturn(true);

		assertTrue(instance.vote(assignables, new Object()));
	}

}
