package com.ft.unifiedContentModel.core.net;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class AllowedPathFactoryTest {
	
	private static final String UUID = "123";
	
	private static final String ITEM_ID = "itemId";
	private static final String FAKE_PARAM = "fake";
	
	private static final String RESOLVED_ITEM_READ_PATH = "/content/items/v1/123";

	private static final String RESOLVED_ITEM_LIST_PATH = Paths.ITEM_LIST;
	
	
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
	
}
