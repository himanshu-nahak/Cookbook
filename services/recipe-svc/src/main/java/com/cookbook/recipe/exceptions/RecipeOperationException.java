package com.cookbook.recipe.exceptions;

public class RecipeOperationException extends RuntimeException {

    // update, delete failure
    public RecipeOperationException(String id, String operation, String reason) {
        super(String.format("%s operation failed for recipe %s: %s", operation, id, reason));
    }

    // creation failure
    public RecipeOperationException(String operation, String reason) {
        super(String.format("%s failed: %s", operation, reason));
    }
}
