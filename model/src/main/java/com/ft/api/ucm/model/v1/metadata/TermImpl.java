package com.ft.api.ucm.model.v1.metadata;

import com.google.common.base.Objects;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"name", "id", "attributes", "taxonomy"})
public class TermImpl implements Term {

  private String id;
  private String name;
  private String taxonomy;
  private Set<Attribute> attributes;

  public TermImpl() {}

  public TermImpl(String id, String name) {
    this.id = StringUtils.isNotBlank(id) ? id : null;
    this.name = StringUtils.isNotBlank(name) ? name : null;
  }

  public TermImpl(String id, String name, String taxonomy, Set<Attribute> attributes) {
    this(id, name);
    this.taxonomy = StringUtils.isNotBlank(taxonomy) ? taxonomy : null;
    this.attributes = attributes;
  }

  @Override
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getTaxonomy() {
    return taxonomy;
  }

  public void setTaxonomy(String taxonomy) {
    this.taxonomy = taxonomy;
  }

  @Override
  public Set<Attribute> getAttributes() {
    return attributes;
  }

  public void setAttributes(Set<Attribute> attributes) {
    this.attributes = attributes;
  }

  @Override
  public boolean equals(Object that) {
    if (that == null) {
      return false;
    }
    if (that == this) {
      return true;
    }
    if (that instanceof TermImpl) {
      TermImpl thatTerm = (TermImpl) that;
      return Objects.equal(id, thatTerm.getId())
          && Objects.equal(name, thatTerm.getName())
          && Objects.equal(taxonomy, thatTerm.getTaxonomy())
          && Objects.equal(attributes, thatTerm.getAttributes());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, name, taxonomy, attributes);
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this)
        .add("id", id)
        .add("name", name)
        .add("taxonomy", taxonomy)
        .add("attrs", attributes)
        .toString();
  }
}
