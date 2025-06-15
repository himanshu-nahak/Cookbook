package com.cookbook.recipe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cookbook.recipe.model.Recipe;

public interface RecipeRepository extends MongoRepository<Recipe, String> {

}
