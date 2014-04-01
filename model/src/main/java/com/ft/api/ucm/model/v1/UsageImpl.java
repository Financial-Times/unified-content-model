package com.ft.api.ucm.model.v1;

import com.ft.api.ucm.model.v1.metadata.Term;

import java.util.SortedSet;

public class UsageImpl implements Usage {

    private SortedSet<Term> publication;

    public UsageImpl() {};

    public UsageImpl(SortedSet<Term> publication) {
        this.publication = publication;
    }

    @Override
    public SortedSet<Term> getPublication() {
        return publication;
    }

    public void setPublication(SortedSet<Term> publication) {
        this.publication = publication;
    }

}
