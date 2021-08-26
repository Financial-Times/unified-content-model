package com.ft.api.ucm.model.v1.aspect;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verifyZeroInteractions;

import com.ft.api.ucm.model.v1.AspectSetAware;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HardwiredAspectSetSelectionPolicyTest {

  @Mock private Set<AspectSet> mockAspectSets;
  @Mock private AspectSet mockAspectSet;
  @Mock private AspectSetAware mockAspectSetAware;

  private HardwiredAspectSetSelectionPolicy instance;

  @Test(expected = IllegalArgumentException.class)
  public void ifSuppliedAspectSetIsNullExceptionThrown() {
    new HardwiredAspectSetSelectionPolicy(null);
  }

  @Test
  public void sameAspectSetReturnedAlways() {
    instance = new HardwiredAspectSetSelectionPolicy(mockAspectSet);
    assertEquals(mockAspectSet, instance.match(mockAspectSets, mockAspectSetAware.getClass()));
    verifyZeroInteractions(mockAspectSets);
  }
}
