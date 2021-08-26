package com.ft.api.ucm.model.v1;

import java.util.List;

public interface BlogPost {

  String getId();

  Title getTitle();

  Lifecycle getLifecycle();

  Location getLocation();

  Master getMaster();

  Packaging getPackaging();

  Body getBody();

  Summary getSummary();

  Metadata getMetadata();

  List<ContentPackageEntry> getPackage();

  List<Image> getImages();

  Editorial getEditorial();
}
