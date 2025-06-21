package com.cookbook.recipe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.recipe.dto.RecipeRequestDTO;
import com.cookbook.recipe.dto.RecipeResponseDTO;
import com.cookbook.recipe.mapper.RecipeMapper;
import com.cookbook.recipe.model.Recipe;
import com.cookbook.recipe.model.User;
import com.cookbook.recipe.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper; // Inject mapper

    @Override
    public List<RecipeResponseDTO> getAllRecipes() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::toRecipeUserResponseDTO)
                .toList();
    }

    @Override
    public RecipeResponseDTO createRecipe(RecipeRequestDTO requestRecipe) {
        // TODO: Implement auth and discontinue hardcoded user
        User user = new User(String.valueOf(Math.random() * 100000), "Himanshu", "Nahak", "himanshu@gmail.com");
        Recipe recipe = recipeMapper.toRecipeEntity(requestRecipe, user.getId(),
                user.getFirstName() + " " + user.getLastName());
        Recipe savedRecipe = recipeRepository.save(recipe);
        return recipeMapper.toRecipeUserResponseDTO(savedRecipe);

    }

}
