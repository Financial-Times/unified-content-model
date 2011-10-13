package com.ft.unifiedContentModel.marshalling.bind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class ResponseNamespacePrefixMapper extends NamespacePrefixMapper {

	private Map<String, String> namespaceMappings = new HashMap<String, String>();
	private String[] interpolatedNamespacesAndPrefixes;
	private String[] nameSpaceUris;
	
	public ResponseNamespacePrefixMapper(Map<String,String> namespaceMappings){
		this.namespaceMappings = namespaceMappings;
		
		interpolatedNamespacesAndPrefixes = flattenNamespaces();
		nameSpaceUris = namespaceMappings.values().toArray(new String[namespaceMappings.size()]);
	}

	@Override
	public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
		String prefix = namespaceMappings.get(namespaceUri);
		return (null != prefix) ? prefix : com.ft.unifiedContentModel.model.XSDs.CONTENTITEM_NAMESPACE_PREFIX;
	}

	@Override
	public String[] getPreDeclaredNamespaceUris() {
		return nameSpaceUris;
	}

	@Override
	public String[] getContextualNamespaceDecls() {
		return interpolatedNamespacesAndPrefixes;
	}

	private String[] flattenNamespaces() {
		List<String> values = Lists.newArrayList();
		for (String key : namespaceMappings.keySet()) {
			values.add(key);
			values.add(namespaceMappings.get(key));
		}
		return values.toArray(new String[values.size()]);
	}

}
