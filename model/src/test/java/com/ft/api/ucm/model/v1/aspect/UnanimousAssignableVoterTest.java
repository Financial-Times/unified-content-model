package com.ft.api.ucm.model.v1.aspect;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.google.common.collect.Sets;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UnanimousAssignableVoterTest {

  @Mock private Assignable assignable;
  @Mock private Assignable anotherAssignable;

  private UnanimousAssignableVoter instance;
  private Set<Assignable> assignables;

  @BeforeEach
  public void setUp() throws Exception {
    instance = new UnanimousAssignableVoter();
    assignables = Sets.newHashSet(assignable, anotherAssignable);
  }

  @Test
  public void voteFailsIfNotAllAssignablesAgree() {
    assertThat("Should not be assignable", !instance.vote(assignables, new Object()));
  }

  @Test
  public void votePassesIfAllAssignablesAgree() {
    when(assignable.assignableFrom(any())).thenReturn(true);
    when(anotherAssignable.assignableFrom(any())).thenReturn(true);

    assertThat("Should be assignable", instance.vote(assignables, new Object()));
  }
}
