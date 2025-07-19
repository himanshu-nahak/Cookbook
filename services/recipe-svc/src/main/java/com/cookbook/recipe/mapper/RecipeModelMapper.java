package com.cookbook.recipe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.cookbook.recipe.dto.RecipeRequestDTO;
import com.cookbook.recipe.dto.RecipeResponseDTO;
import com.cookbook.recipe.dto.RecipeUpdateDTO;
import com.cookbook.recipe.enums.MealType;
import com.cookbook.recipe.model.Recipe;

@Mapper(componentModel = "spring")
public interface RecipeModelMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "userId", ignore = true)
    Recipe toRecipeEntity(RecipeRequestDTO dto, String userId, String createdBy);

    // Recipe to RecipeResponseDTO
    @Mapping(target = "createdBy", source = "createdBy")
    RecipeResponseDTO toRecipeUserResponseDTO(Recipe recipe);

    // Update Recipe from RecipeUpdateDTO
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    void updateRecipeFromDto(@MappingTarget Recipe recipe, RecipeUpdateDTO dto);

}
