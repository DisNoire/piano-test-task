package io.piano.disnoire.param;

public enum Sort {
    ACTIVITY("activity"),
    VOTES("votes"),
    CREATION("creation"),
    RELEVANCE("relevance");

    private String sort;

    Sort(String sort) {
        this.sort = sort;
    }

    public String toString() {
        return this.sort;
    }
}
