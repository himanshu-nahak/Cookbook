package com.cookbook.recipe.enums;

public enum MealType {
    BREAKFAST("Breakfast"),
    MAIN_COURSE("Main Course"),
    SNACK("Snack"),
    DESSERT("Dessert");

    private final String displayName;

    MealType(String displayName) {
        this.displayName = displayName;
    }

    public String get() {
        return displayName;
    }

    // Add this method to safely convert from string
    public static MealType fromString(String value) {
        if (value == null)
            return null;

        for (MealType type : values()) {
            if (type.displayName.equalsIgnoreCase(value) ||
                    type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown meal type: " + value);
    }
}
