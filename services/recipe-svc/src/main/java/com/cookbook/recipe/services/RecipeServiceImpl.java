package com.cookbook.recipe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.recipe.model.Recipe;
import com.cookbook.recipe.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

}
