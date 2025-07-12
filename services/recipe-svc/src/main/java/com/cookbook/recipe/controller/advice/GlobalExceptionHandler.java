package com.cookbook.recipe.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.cookbook.recipe.exceptions.ApiError;
import com.cookbook.recipe.exceptions.RecipeAuthorizationException;
import com.cookbook.recipe.exceptions.RecipeNotFoundException;
import com.cookbook.recipe.exceptions.RecipeOperationException;
import com.cookbook.recipe.exceptions.RecipeSearchException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private ResponseEntity<ApiError> buildErrorResponse(
            HttpStatus status,
            String message,
            WebRequest request) {
        return new ResponseEntity<>(new ApiError(status, message, request.getDescription(false)), status);
    }

    @ExceptionHandler(RecipeNotFoundException.class)
    public ResponseEntity<ApiError> handleRecipeNotFound(RecipeNotFoundException ex, WebRequest request) {
        log.warn("Recipe not found: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request);
    }

    @ExceptionHandler(RecipeOperationException.class)
    public ResponseEntity<ApiError> handleRecipeOperation(
            RecipeOperationException ex, WebRequest request) {
        return buildErrorResponse(HttpStatus.CONFLICT, ex.getMessage(), request);
    }

    @ExceptionHandler(RecipeAuthorizationException.class)
    public ResponseEntity<ApiError> handleRecipeAuthorization(
            RecipeAuthorizationException ex, WebRequest request) {
        return buildErrorResponse(HttpStatus.FORBIDDEN, ex.getMessage(), request);
    }

    @ExceptionHandler(RecipeSearchException.class)
    public ResponseEntity<ApiError> handleRecipeSearch(
            RecipeSearchException ex, WebRequest request) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGlobalException(
            Exception ex, WebRequest request) {
        log.error("Unhandled exception occurred", ex); // Log full stacktrace
        String message = ex.getCause() != null ? ex.getCause().getMessage() : "An unexpected error occurred";
        return buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                message,
                request);
    }

}
