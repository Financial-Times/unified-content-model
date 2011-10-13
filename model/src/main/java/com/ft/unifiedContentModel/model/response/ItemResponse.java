package com.ft.unifiedContentModel.model.response;

import static org.springframework.util.Assert.notNull;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.ft.unifiedContentModel.core.net.Url;
import com.ft.unifiedContentModel.model.ArticleEntity;
import com.ft.unifiedContentModel.model.XSDs;

@XmlRootElement(name="response", namespace=XSDs.ITEM_RESPONSE_NAMESPACE)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@XmlType(namespace=XSDs.ITEM_RESPONSE_NAMESPACE, propOrder = {"total","requestUrl", "item"})
public class ItemResponse extends AbstractResponse {
	
	private ArticleEntity item;
	
	@SuppressWarnings("unused")
	private ItemResponse() {
		// required for JAXB
	}
	
	public ItemResponse(ArticleEntity item, Url requestUrl) {
		notNull(item);
		notNull(requestUrl);
		this.item = item;
		setTotal(1);
		setRequestUrl(requestUrl.toString());
	}
	
	@XmlElement(name="item", namespace=XSDs.CONTENTITEM_NAMESPACE )
	public ArticleEntity getItem() {
		return item;
	}

	/**
	 * Required for JAXB, please do NOT use
	 */
	public void setItem(ArticleEntity item) {
		this.item = item;
	}
}
