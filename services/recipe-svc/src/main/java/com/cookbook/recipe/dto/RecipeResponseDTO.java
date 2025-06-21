package com.cookbook.recipe.dto;

import java.time.Instant;
import java.util.List;
import com.cookbook.recipe.model.Ingredient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeResponseDTO {
    private String id;
    private String name;
    private List<Ingredient> ingredients;
    private String mealType; // TODO: use Enum
    private String cuisineType; // TODO: use Enum
    private String instructions;
    private String imageUrl;
    private String createdBy;
    private Instant createdAt;
    private Instant updatedAt;

}
