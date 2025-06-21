package com.cookbook.recipe.model;

import lombok.Data;

@Data
public class Ingredient {
    private String name;
    private Double quantity;
    private String unit; // TODO: use Enum
}