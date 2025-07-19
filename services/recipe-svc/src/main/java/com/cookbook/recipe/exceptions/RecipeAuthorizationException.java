package com.cookbook.recipe.exceptions;

public class RecipeAuthorizationException extends RuntimeException {
    public RecipeAuthorizationException(String userId, String operation) {
        super(String.format("User %s not authorized for %s operation", userId, operation));
    }
}
