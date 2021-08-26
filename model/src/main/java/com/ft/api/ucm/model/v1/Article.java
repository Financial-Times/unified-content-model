package com.ft.api.ucm.model.v1;

import java.util.List;

public interface Article {

  Editorial getEditorial();

  Location getLocation();

  Master getMaster();

  Packaging getPackaging();

  Body getBody();

  Summary getSummary();

  Metadata getMetadata();

  List<ContentPackageEntry> getPackage();

  Title getTitle();

  Lifecycle getLifecycle();
}
