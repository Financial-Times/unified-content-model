package com.ft.api.ucm.model.v1;

import com.ft.api.ucm.model.v1.metadata.Tag;

import java.util.Set;

public class UsageImpl implements Usage {

    private Set<Tag> publication;

    public UsageImpl() { }

    public UsageImpl(Set<Tag> publication) {
        this.publication = publication;
    }

    @Override
    public Set<Tag> getPublication() {
        return publication;
    }

    public void setPublication(Set<Tag> publication) {
        this.publication = publication;
    }

}
