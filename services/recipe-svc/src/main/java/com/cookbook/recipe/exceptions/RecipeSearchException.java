package com.cookbook.recipe.exceptions;

public class RecipeSearchException extends RuntimeException {
    // For invalid parameters
    public RecipeSearchException(String message) {
        super("Invalid search request: " + message);
    }

    // For internal search failures
    public RecipeSearchException(String message, Throwable cause) {
        super("Search failed: " + message, cause);
    }
}