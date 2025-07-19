package com.cookbook.recipe.enums;

public enum CuisineType {
    INDIAN("Indian"),
    CHINESE("Chinese"),
    ITALIAN("Italian"),
    FRENCH("French");

    private final String displayName;

    CuisineType(String displayName) {
        this.displayName = displayName;
    }

    public String getString() {
        return displayName;
    }
}
