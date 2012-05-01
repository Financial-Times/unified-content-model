package com.ft.unifiedContentModel.model.response;

import static org.springframework.util.Assert.notNull;

import com.ft.unifiedContentModel.core.net.Url;
import com.ft.unifiedContentModel.model.ArticleEntity;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"requestUrl", "item"})
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
		setRequestUrl(requestUrl.toString());
	}

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
