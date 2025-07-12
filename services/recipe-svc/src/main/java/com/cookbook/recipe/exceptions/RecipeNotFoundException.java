package com.cookbook.recipe.exceptions;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(String id) {
        super("Recipe not found with id: " + id);
    }
}
