package com.cookbook.recipe.dto;

import java.time.Instant;
import java.util.List;

import org.hibernate.validator.constraints.URL;

import com.cookbook.recipe.model.Ingredient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RecipeRequestDTO {

    @NotBlank(message = "Recipe name is required")
    @Size(max = 100, message = "Recipe name must be less than 100 characters")
    private String name;

    @NotEmpty(message = "Atleast one ingredient is required")
    private List<@Valid Ingredient> ingredients;

    @NotBlank(message = "Meal type is required")
    private String mealType; // TODO: use Enum

    @NotBlank(message = "Cuisine is required")
    private String cuisineType; // TODO: use Enum

    @NotBlank(message = "Instructions are required")
    private String instructions;

    @URL(message = "URL must be valid")
    private String imageUrl;
}
