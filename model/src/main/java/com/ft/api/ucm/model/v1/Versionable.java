package com.ft.api.ucm.model.v1;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public interface Versionable {

  String getModelVersion();
}
