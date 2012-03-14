package com.ft.unifiedContentModel.core.net;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class AllowedPathFactoryTest {
	
	private static final String UUID = "123";
	private static final String ANOTHER_UUID = "456";
	
	private static final String ITEM_ID = "itemId";
	private static final String PAGE_ID = "pageId";
	private static final String COMPONENT_ID = "componentId";
	private static final String FAKE_PARAM = "fake";
	
	private static final String RESOLVED_ITEM_READ_PATH = "/content/items/v1/123";
	private static final String RESOLVED_COMPONENT_READ_PATH = "/site/v1/pages/123/components/456";
	private static final String RESOLVED_PAGE_READ_PATH = "/site/v1/pages/123";
	
	private static final String RESOLVED_ITEM_LIST_PATH = Paths.ITEM_LIST;
	private static final String RESOLVED_PAGE_LIST_PATH = Paths.PAGE_LIST;
	
	
	private AllowedPathFactory factory;
	
	@Before
	public void setup() {
		factory = new AllowedPathFactory();
	}
	
	@Test
	public void createPathItem() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put(ITEM_ID, UUID);
		Path path = factory.createPath(Paths.ITEM_READ, vars);
		assertEquals(RESOLVED_ITEM_READ_PATH, path.toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cannotCreatePathItemNullVars() {
		factory.createPath(Paths.ITEM_READ, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cannotCreatePathItemWithoutVars() {
		factory.createPath(Paths.ITEM_READ);
	}
	
	@Test
	public void createPathItemWithAdditionalFakeParam() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put(ITEM_ID, UUID);
		vars.put(FAKE_PARAM, "fake");
		Path path = factory.createPath(Paths.ITEM_READ, vars);
		assertEquals(RESOLVED_ITEM_READ_PATH, path.toString());
	}
	
	@Test
	public void createPathItems() {
		Path path = factory.createPath(Paths.ITEM_LIST);
		assertEquals(RESOLVED_ITEM_LIST_PATH, path.toString());
	}
	
	@Test
	public void canCreatePathItemsWithFakeParams() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put(FAKE_PARAM, "fake");
		Path path = factory.createPath(Paths.ITEM_LIST, vars);
		assertEquals(RESOLVED_ITEM_LIST_PATH, path.toString());
	}
	
	@Test
	public void createPathPage() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put(PAGE_ID, UUID);
		Path path = factory.createPath(Paths.PAGE_READ, vars);
		assertEquals(RESOLVED_PAGE_READ_PATH, path.toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cannotCreatePathPageNullVars() {
		factory.createPath(Paths.PAGE_READ, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cannotCreatePathPageWithoutVars() {
		factory.createPath(Paths.PAGE_READ);
	}
	
	@Test
	public void createPathPageWithAdditionalFakeParam() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put(PAGE_ID, UUID);
		vars.put(FAKE_PARAM, "fake");
		Path path = factory.createPath(Paths.PAGE_READ, vars);
		assertEquals(RESOLVED_PAGE_READ_PATH, path.toString());
	}
	
	@Test
	public void createPathPages() {
		Path path = factory.createPath(Paths.PAGE_LIST);
		assertEquals(RESOLVED_PAGE_LIST_PATH, path.toString());
	}
	
	@Test
	public void canCreatePathPagesWithFakeParams() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put(FAKE_PARAM, "fake");
		Path path = factory.createPath(Paths.PAGE_LIST, vars);
		assertEquals(RESOLVED_PAGE_LIST_PATH, path.toString());
	}
	
	
	@Test
	public void createPathComponent() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put(PAGE_ID, UUID);
		vars.put(COMPONENT_ID, ANOTHER_UUID);
		Path path = factory.createPath(Paths.COMPONENT_READ, vars);
		assertEquals(RESOLVED_COMPONENT_READ_PATH, path.toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cannotCreatePathComponentNullVars() {
		factory.createPath(Paths.COMPONENT_READ, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cannotCreatePathComponentWithoutVars() {
		factory.createPath(Paths.COMPONENT_READ);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cannotCreatePathComponentWithMissingVar() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put(COMPONENT_ID, ANOTHER_UUID);
		factory.createPath(Paths.COMPONENT_READ, vars);
	}
	
	

	

}
