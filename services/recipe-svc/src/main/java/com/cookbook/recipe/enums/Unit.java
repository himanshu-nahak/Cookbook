package com.cookbook.recipe.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Unit {
    GRAM("g"),
    KILOGRAM("kg"),
    MILLILITER("ml"),
    CUP("cup"),
    TABLESPOON("tbsp"),
    TEASPOON("tsp"),
    PIECE("piece");

    private final String abbreviation;

    Unit(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @JsonValue
    public String getAbbreviation() {
        return abbreviation;
    }

    @JsonCreator
    public static Unit fromAbbreviation(String abbreviation) {
        for (Unit unit : values()) {
            if (unit.abbreviation.equalsIgnoreCase(abbreviation)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("Unknown unit abbreviation: " + abbreviation);
    }

}
