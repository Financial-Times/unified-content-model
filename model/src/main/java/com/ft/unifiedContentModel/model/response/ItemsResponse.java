package com.ft.unifiedContentModel.model.response;

import static org.springframework.util.Assert.notNull;

import com.ft.unifiedContentModel.core.net.Url;
import com.ft.unifiedContentModel.model.ContentEntity;
import java.util.List;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"total","requestUrl", "items"})
public class ItemsResponse extends AbstractResponse {

	private int total;
	
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

	public List<ContentEntity> getItems() {
		return items;
	}

	/**
	 * Required for JAXB, please do NOT use
	 */
	public void setItems(List<ContentEntity> items) {
		this.items = items;
	}

	
	protected void setTotal(int total) {
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

}
