package com.cookbook.recipe.model;

import java.time.Instant;
import java.util.List;

import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "recipes")
public class Recipe {

    @Id
    private String id;

    @NotBlank(message = "Recipe name is required")
    @Size(max = 100, message = "Recipe name must be less than 100 characters")
    private String name;

    @NotEmpty(message = "Atleast one ingredient is required")
    private List<@Valid Ingredient> ingredients;

    @NotBlank(message = "Meal type is required")
    private String mealType; // TODO: use Enum

    @NotBlank(message = "Cuisine is required")
    private String cuisineType; // TODO: use Enum

    @NotBlank(message = "Instructions are required")
    private String instructions;

    @URL(message = "URL must be valid")
    private String imageUrl;

    private String createdBy;
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;
    private String userId;
}
