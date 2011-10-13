package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public final class XSDs {

	private XSDs() {}
	
	public static final String DOT_XSD = ".xsd";
	
	private static final String CONTENT_API_BASE_URL = "http://api.ft.com/";
	private static final String CONTENT_API = "contentAPI";
	public static final String CONTENT_API_BASE = CONTENT_API_BASE_URL + CONTENT_API + "/";	

	private static final String ITEM_RESPONSE = "itemResponse";
	private static final String ITEMS_RESPONSE = "itemsResponse";
	private static final String CONTENTITEM = "contentItem";
	private static final String PAGE = "page";
	private static final String METADATA = "metadata";
	private static final String IMAGE = "image";
	private static final String ASPECT = "aspect";
	private static final String FIELD = "field";

	public static final String CONTENT_API_NAMESPACE = CONTENT_API_BASE_URL + CONTENT_API;
	public static final String ITEM_RESPONSE_NAMESPACE = CONTENT_API_BASE + ITEM_RESPONSE;
	public static final String ITEMS_RESPONSE_NAMESPACE = CONTENT_API_BASE + ITEMS_RESPONSE;
	public static final String CONTENTITEM_NAMESPACE = CONTENT_API_BASE + CONTENTITEM;
	public static final String METADATA_NAMESPACE = CONTENT_API_BASE + METADATA;
	public static final String IMAGE_NAMESPACE = CONTENT_API_BASE + IMAGE;
	public static final String ASPECT_NAMESPACE = CONTENT_API_BASE + ASPECT;
	public static final String FIELD_NAMESPACE = CONTENT_API_BASE + FIELD;
	public static final String SCHEMAINSTANCE_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";
	
	public static final String ITEM_RESPONSE_NAMESPACE_PREFIX = "item";
	public static final String ITEMS_RESPONSE_NAMESPACE_PREFIX = "items";
	public static final String CONTENTITEM_NAMESPACE_PREFIX = "i";
	public static final String METADATA_NAMESPACE_PREFIX = "m";
	public static final String IMAGE_NAMESPACE_PREFIX = "im";
	public static final String ASPECT_NAMESPACE_PREFIX = "a";
	public static final String FIELD_NAMESPACE_PREFIX = "f";
	public static final String SCHEMAINSTANCE_NAMESPACE_PREFIX = "xsi";
	
	public static final String CONTENT_API_BASE_PATH_TO_SCHEMA = "com/ft/unifiedContentModel/model/schema/";
	
	public static final String CONTENT_API_SCHEMA_LOCATION = CONTENT_API_BASE_PATH_TO_SCHEMA + CONTENT_API + DOT_XSD;
	public static final String ITEM_RESPONSE_SCHEMA_LOCATION = CONTENT_API_BASE_PATH_TO_SCHEMA + ITEM_RESPONSE + DOT_XSD;
	public static final String ITEMS_RESPONSE_SCHEMA_LOCATION = CONTENT_API_BASE_PATH_TO_SCHEMA + ITEMS_RESPONSE + DOT_XSD;
	public static final String CONTENTITEM_SCHEMA_LOCATION = CONTENT_API_BASE_PATH_TO_SCHEMA + CONTENTITEM + DOT_XSD;
	public static final String PAGE_SCHEMA_LOCATION = CONTENT_API_BASE_PATH_TO_SCHEMA + PAGE + DOT_XSD;
	public static final String METADATA_SCHEMA_LOCATION = CONTENT_API_BASE_PATH_TO_SCHEMA + METADATA + DOT_XSD;
	public static final String IMAGE_SCHEMA_LOCATION = CONTENT_API_BASE_PATH_TO_SCHEMA + IMAGE + DOT_XSD;
	public static final String ASPECT_SCHEMA_LOCATION = CONTENT_API_BASE_PATH_TO_SCHEMA + ASPECT + DOT_XSD;
	public static final String FIELD_SCHEMA_LOCATION = CONTENT_API_BASE_PATH_TO_SCHEMA + FIELD + DOT_XSD;
	
}
