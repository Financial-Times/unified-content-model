package com.ft.unifiedContentModel.model;

import java.util.List;
import java.util.Map;

public interface AssetAware {

	List<Asset> getAssets();
	Map<String,Asset> getAssetMap();
	void setAssets(List<Asset> assets);
	void add(Asset asset);

	//@Deprecated
	List<MediaAsset> getMediaAssets();
	Map<String,MediaAsset> getMediaAssetMap();
	void setMediaAssets(List<MediaAsset> mediaAssets);
	void add(MediaAsset asset);

}
