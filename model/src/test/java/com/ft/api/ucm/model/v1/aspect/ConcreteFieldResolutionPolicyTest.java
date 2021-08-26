package com.ft.api.ucm.model.v1.aspect;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConcreteFieldResolutionPolicyTest {

  private static final String NAME = "name";
  private static final String NON_EXISTENT = "foo";
  private static final Object TEST_OBJ =
      new Object() {
        @SuppressWarnings("unused")
        public String getName() {
          return NAME;
        }
      };

  @Mock private Field mockField;
  private ConcreteFieldResolutionPolicy instance;

  @Before
  public void setUp() throws Exception {
    instance = new ConcreteFieldResolutionPolicy();
  }

  @Test
  public void existingPropertyIsFound() {
    when(mockField.toString()).thenReturn(NAME);
    assertThat(instance.hasField(mockField, TEST_OBJ), is(TRUE));
  }

  @Test
  public void nonExistantPropertyIsNotFound() {
    when(mockField.toString()).thenReturn(NON_EXISTENT);
    assertThat(instance.hasField(mockField, TEST_OBJ), is(FALSE));
  }
}
