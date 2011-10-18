package com.ft.unifiedContentModel.testsupport.acceptance.util;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.jbehave.core.io.StoryPathResolver;
import org.jbehave.core.junit.JUnitStories;
import org.junit.Test;

import com.ft.unifiedContentModel.testsupport.acceptance.util.CasePreservingTestSuffixRemovingResolver;


public class CasePreservingStoriesSuffixResolverTest {

	@Test
	public void shouldResolveClassNameRemovingStoriesSuffix() {
		StoryPathResolver resolver = new CasePreservingTestSuffixRemovingResolver();
		assertEquals(resolver.resolve(CamelCaseTest.class), "**/CamelCase.story");
	}
	
	static class CamelCaseTest extends JUnitStories {
		
		@Override
		protected List<String> storyPaths() {
			return null;
		}
	}
	
}
