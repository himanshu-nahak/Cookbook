package com.cookbook.recipe.mapper;

import com.cookbook.recipe.dto.RecipeRequestDTO;
import com.cookbook.recipe.dto.RecipeResponseDTO;
import com.cookbook.recipe.model.Recipe;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapper {
    public RecipeResponseDTO toRecipeUserResponseDTO(Recipe recipe) {
        return RecipeResponseDTO.builder()
                .id(recipe.getId())
                .name(recipe.getName())
                .ingredients(recipe.getIngredients())
                .mealType(recipe.getMealType())
                .cuisineType(recipe.getCuisineType())
                .instructions(recipe.getInstructions())
                .imageUrl(recipe.getImageUrl())
                .createdBy(recipe.getCreatedBy())
                .createdAt(recipe.getCreatedAt())
                .updatedAt(recipe.getUpdatedAt())
                .build();
    }

    public Recipe toRecipeEntity(RecipeRequestDTO requestDTO, String userId, String createdBy) {
        return Recipe.builder()
                .name(requestDTO.getName())
                .cuisineType(requestDTO.getCuisineType())
                .ingredients(requestDTO.getIngredients())
                .imageUrl(requestDTO.getImageUrl())
                .instructions(requestDTO.getInstructions())
                .createdBy(createdBy)
                .mealType(requestDTO.getMealType())
                .userId(userId)
                .build();
    }

}
