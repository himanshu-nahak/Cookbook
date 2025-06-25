package com.cookbook.recipe.mapper;

import com.cookbook.recipe.dto.RecipeRequestDTO;
import com.cookbook.recipe.dto.RecipeResponseDTO;
import com.cookbook.recipe.dto.RecipeUpdateDTO;
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

    public void updateRecipeFromDto(Recipe existingRecipe, RecipeUpdateDTO updateRequestRecipe) {
        if (updateRequestRecipe.getName() != null) {
            existingRecipe.setName(updateRequestRecipe.getName());
        }
        if (updateRequestRecipe.getCuisineType() != null) {
            existingRecipe.setCuisineType(updateRequestRecipe.getCuisineType());
        }
        if (updateRequestRecipe.getImageUrl() != null) {
            existingRecipe.setImageUrl(updateRequestRecipe.getImageUrl());
        }
        if (updateRequestRecipe.getIngredients() != null) {
            existingRecipe.setIngredients(updateRequestRecipe.getIngredients());
        }
        if (updateRequestRecipe.getInstructions() != null) {
            existingRecipe.setInstructions(updateRequestRecipe.getInstructions());
        }
        if (updateRequestRecipe.getMealType() != null) {
            existingRecipe.setMealType(updateRequestRecipe.getMealType());
        }
    }

}
