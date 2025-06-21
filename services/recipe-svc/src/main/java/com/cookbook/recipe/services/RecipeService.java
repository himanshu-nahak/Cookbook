package com.cookbook.recipe.services;

import java.util.List;

import com.cookbook.recipe.dto.RecipeRequestDTO;
import com.cookbook.recipe.dto.RecipeResponseDTO;
import com.cookbook.recipe.model.Recipe;

public interface RecipeService {

    public List<RecipeResponseDTO> getAllRecipes();

    public RecipeResponseDTO createRecipe(RecipeRequestDTO requestRecipe);

}
