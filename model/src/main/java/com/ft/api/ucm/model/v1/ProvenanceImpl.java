package com.ft.api.ucm.model.v1;

import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.StringUtils;

public class ProvenanceImpl implements Provenance {

  private String originatingParty;

  public ProvenanceImpl() {}

  public ProvenanceImpl(String originatingParty) {
    this.originatingParty = StringUtils.isNotBlank(originatingParty) ? originatingParty : null;
  }

  @Override
  public String getOriginatingParty() {
    return originatingParty;
  }

  public void setOriginatingParty(String originatingParty) {
    this.originatingParty = originatingParty;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("originatingParty", originatingParty).toString();
  }
}
