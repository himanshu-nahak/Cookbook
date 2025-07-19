package com.cookbook.recipe.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cookbook.recipe.dto.RecipeRequestDTO;
import com.cookbook.recipe.dto.RecipeResponseDTO;
import com.cookbook.recipe.dto.RecipeUpdateDTO;
import com.cookbook.recipe.exceptions.RecipeNotFoundException;
import com.cookbook.recipe.exceptions.RecipeOperationException;
import com.cookbook.recipe.mapper.RecipeMapper;
// import com.cookbook.recipe.mapper.RecipeModelMapper;
import com.cookbook.recipe.model.Recipe;
import com.cookbook.recipe.model.User;
import com.cookbook.recipe.repository.RecipeRepository;
import com.mongodb.MongoException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    // Manual mapper. Discontinued MapStruct. Commented all usages below.
    private final RecipeMapper recipeMapper;
    // private final RecipeModelMapper recipeModelMapper;

    @Override
    public List<RecipeResponseDTO> getAllRecipes() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::toRecipeUserResponseDTO)
                .toList();

        // return recipeRepository.findAll()
        // .stream()
        // .map(recipeModelMapper::toRecipeUserResponseDTO)
        // .toList();
    }

    @Override
    public RecipeResponseDTO createRecipe(@Valid RecipeRequestDTO requestRecipe) {
        try {
            // TODO: Implement auth and discontinue hardcoded user
            User user = new User(String.valueOf(Math.random() * 100000), "Himanshu", "Nahak", "himanshu@gmail.com");
            Recipe recipe = recipeMapper.toRecipeEntity(requestRecipe, user.getId(),
                    user.getFirstName() + " " + user.getLastName());
            // Recipe recipe = recipeModelMapper.toRecipeEntity(requestRecipe, user.getId(),
            // user.getFirstName() + " " + user.getLastName());
            Recipe savedRecipe = recipeRepository.save(recipe);
            return recipeMapper.toRecipeUserResponseDTO(savedRecipe);
            // return recipeModelMapper.toRecipeUserResponseDTO(savedRecipe);
        } catch (MongoException e) {
            log.error("MongoDB error while creating recipe. Request: {}", e);
            throw new RecipeOperationException("Creation", "Database error while creating recipe");
        } catch (Exception e) {
            log.error("Unexpected error during recipe creation. Request: {}", e);
            throw new RecipeOperationException("Creation", "Unexpected Error during Recipe Creation");
        }
    }

    @Override
    public void deleteRecipe(String id) {
        if (!recipeRepository.existsById(id)) {
            log.error("Recipe not found. Deletion failed.");
            throw new RecipeNotFoundException(id);
        }
        try {
            recipeRepository.deleteById(id);
        } catch (MongoException e) {
            log.error("MongoDB error while creating recipe. Request: {}", e);
            throw new RecipeOperationException("Deletion", "Database error while deleting recipe");
        } catch (Exception e) {
            log.error("Unexpected error during recipe deletion. Request: {}", e);
            throw new RecipeOperationException("Deletion", "Unexpected Error during Recipe deletion");
        }
    }

    @Override
    public RecipeResponseDTO getRecipeById(String id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
        return recipeMapper.toRecipeUserResponseDTO(recipe);
        // Recipe recipe = recipeRepository.findById(id)
        // .orElseThrow(() -> new RecipeNotFoundException(id));
        // return recipeModelMapper.toRecipeUserResponseDTO(recipe);
    }

    @Override
    public RecipeResponseDTO updateRecipe(String id, @Valid RecipeUpdateDTO updateRequestRecipe) {
        Recipe existingRecipe = recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException(id));
        recipeMapper.updateRecipeFromDto(existingRecipe, updateRequestRecipe);
        // recipeModelMapper.updateRecipeFromDto(existingRecipe, updateRequestRecipe);
        try {
            Recipe updatedRecipe = recipeRepository.save(existingRecipe);
            return recipeMapper.toRecipeUserResponseDTO(updatedRecipe);
            // return recipeModelMapper.toRecipeUserResponseDTO(updatedRecipe);
        } catch (MongoException e) {
            log.error("MongoDB error while updating recipe. Request: {}", e);
            throw new RecipeOperationException("Updation", "Database error while updatimg recipe");
        } catch (Exception e) {
            log.error("Unexpected error during recipe update. Request: {}", e);
            throw new RecipeOperationException("Updation", "Unexpected Error during Recipe update");
        }
    }

}
