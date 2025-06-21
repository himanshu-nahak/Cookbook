package com.cookbook.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cookbook.recipe.services.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cookbook.recipe.dto.RecipeRequestDTO;
import com.cookbook.recipe.dto.RecipeResponseDTO;
import com.cookbook.recipe.model.Recipe;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping()
    public List<RecipeResponseDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeResponseDTO createRecipe(@RequestBody RecipeRequestDTO request) {
        return recipeService.createRecipe(request);
    }

}
