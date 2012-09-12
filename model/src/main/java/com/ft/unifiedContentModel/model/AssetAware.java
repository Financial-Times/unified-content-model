package com.ft.unifiedContentModel.model;

import java.util.List;

public interface AssetAware {

	List<Asset> getAssets();

	void setAssets(List<Asset> assets);

	void add(Asset asset);

}
