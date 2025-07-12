package com.cookbook.recipe.dto;

import java.time.Instant;
import java.util.List;
import com.cookbook.recipe.model.Ingredient;

import lombok.Data;

@Data
public class RecipeRequestDTO {
    private String name;
    private List<Ingredient> ingredients;
    private String mealType; // TODO: use Enum
    private String cuisineType; // TODO: use Enum
    private String instructions;
    private String imageUrl;
}
