package com.cookbook.recipe.dto;

import java.util.List;

import com.cookbook.recipe.model.Ingredient;

import lombok.Data;

@Data
public class RecipeUpdateDTO {
    private String name;
    private List<Ingredient> ingredients;
    private String mealType;
    private String cuisineType;

    private String instructions;

    private String imageUrl; // Optional
}
