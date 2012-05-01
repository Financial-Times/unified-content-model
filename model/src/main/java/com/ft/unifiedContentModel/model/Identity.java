package com.ft.unifiedContentModel.model;

import java.io.Serializable;
import java.util.UUID;
import org.springframework.util.Assert;

public final class Identity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String value;

    public Identity() {
        value = UUID.randomUUID().toString();
    }

    private Identity(String value) {
        this.value = value;
    }

    public static Identity fromValue(String value) {
        Assert.hasText(value);
        return new Identity(value);
    }

    public String getValue() {
        return value;
    }

    @Override
	public int hashCode() {
        return value.hashCode();
    }

    @Override
	public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Identity) {
            Identity other = (Identity) obj;
            return this.value.equals(other.value);
        }
        return false;
    }

    @Override
	public String toString() {
        return getValue();
    }
}
