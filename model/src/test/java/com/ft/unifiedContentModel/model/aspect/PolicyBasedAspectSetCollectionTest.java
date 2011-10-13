package com.ft.unifiedContentModel.model.aspect;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.unifiedContentModel.model.AspectSetAware;
import com.ft.unifiedContentModel.model.aspect.AspectSet;
import com.ft.unifiedContentModel.model.aspect.AspectSetSelectionPolicy;
import com.ft.unifiedContentModel.model.aspect.PolicyBasedAspectSetCollection;

@RunWith(MockitoJUnitRunner.class)
public class PolicyBasedAspectSetCollectionTest {
	
	@Mock private Set<AspectSet> mockAspectSets;
	@Mock private AspectSetSelectionPolicy mockAspectSetSelectionPolicy;
	@Mock private AspectSet mockAspectSet;
	@Mock private AspectSetAware mockAspectSetAware;
	
	private PolicyBasedAspectSetCollection instance;
	
	@Before
	public void setup() {
		when(mockAspectSetSelectionPolicy.match(mockAspectSets, mockAspectSetAware.getClass())).thenReturn(mockAspectSet);
		instance = new PolicyBasedAspectSetCollection(mockAspectSets, mockAspectSetSelectionPolicy);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void constructObjectWithNullAspectSetsRaisesException() {
		new PolicyBasedAspectSetCollection(null, mockAspectSetSelectionPolicy);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void constructObjectWithNullAspectSetSelectionPolicyRaisesException() {
		new PolicyBasedAspectSetCollection(mockAspectSets, null);
	}
	
	@Test
	public void applyToSelectsAspectSetAndDelegates() {
		instance.applyTo(mockAspectSetAware);
		verify(mockAspectSet).applyTo(mockAspectSetAware);
	}

}
