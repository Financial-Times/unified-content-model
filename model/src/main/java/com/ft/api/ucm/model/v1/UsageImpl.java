package com.ft.api.ucm.model.v1;

import com.ft.api.ucm.model.v1.metadata.Term;

import java.util.Set;

public class UsageImpl implements Usage {

    private Set<Term> publications;

    public UsageImpl() { }

    public UsageImpl(Set<Term> publications) {
        this.publications = publications;
    }

    @Override
    public Set<Term> getPublications() {
        return publications;
    }

    public void setPublication(Set<Term> publications) {
        this.publications = publications;
    }

}
