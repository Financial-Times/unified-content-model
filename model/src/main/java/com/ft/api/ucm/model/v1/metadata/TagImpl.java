package com.ft.api.ucm.model.v1.metadata;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class TagImpl implements Tag {

  private Term term;

  public TagImpl() {}

  public TagImpl(Term term) {
    this.term = term;
  }

  @Override
  public Term getTerm() {
    return term;
  }

  public void setTerm(Term term) {
    this.term = term;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("term", term).toString();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null) {
      return false;
    }
    if (that == this) {
      return true;
    }
    if (that instanceof TagImpl) {
      TagImpl thatTag = (TagImpl) that;
      return Objects.equal(this.getTerm(), thatTag.getTerm());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.getTerm());
  }
}
