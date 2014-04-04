package com.ft.api.ucm.model.v1;

import com.ft.api.ucm.model.v1.metadata.Term;

import java.util.Set;
import java.util.SortedSet;

public class UsageImpl implements Usage {

    private Set<Term> publication;

    public UsageImpl() {};

    public UsageImpl(Set<Term> publication) {
        this.publication = publication;
    }

    @Override
    public Set<Term> getPublication() {
        return publication;
    }

    public void setPublication(SortedSet<Term> publication) {
        this.publication = publication;
    }

}
