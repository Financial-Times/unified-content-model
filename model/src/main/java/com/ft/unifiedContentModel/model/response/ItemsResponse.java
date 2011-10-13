package com.ft.unifiedContentModel.model.response;

import static org.springframework.util.Assert.notNull;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.ft.unifiedContentModel.core.net.Url;
import com.ft.unifiedContentModel.model.ArticleEntity;
import com.ft.unifiedContentModel.model.ContentEntity;
import com.ft.unifiedContentModel.model.XSDs;

@XmlRootElement(name="response", namespace=XSDs.ITEMS_RESPONSE_NAMESPACE)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@XmlType(namespace=XSDs.ITEMS_RESPONSE_NAMESPACE, propOrder = {"total","requestUrl", "items"})
public class ItemsResponse extends AbstractResponse {

	private List<ContentEntity> items;
    @SuppressWarnings("unused")
	private ItemsResponse() {
		// required for JAXB
	}
	
	public ItemsResponse(List<ContentEntity> items, Url requestUrl) {
		notNull(items);
		notNull(requestUrl);
		this.items = items;
		setTotal(items.size());
		setRequestUrl(requestUrl.toString());
	}
	
	@XmlElementWrapper(name="contentItems", namespace=XSDs.ITEMS_RESPONSE_NAMESPACE)
	@XmlElements({
		@XmlElement(type=ArticleEntity.class, name="article", namespace=XSDs.CONTENTITEM_NAMESPACE)})
	public List<ContentEntity> getItems() {
		return items;
	}

	/**
	 * Required for JAXB, please do NOT use
	 */
	public void setItems(List<ContentEntity> items) {
		this.items = items;
	}


}
