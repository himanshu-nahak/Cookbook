package com.cookbook.recipe.model;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "recipes")
public class Recipe {

    @Id
    private String id;
    private String name;
    private List<Ingredient> ingredients;
    private String mealType; // TODO: use Enum
    private String cuisineType; // TODO: use Enum
    private String instructions;
    private String imageUrl;
    private String createdBy;
    private Instant createdAt;
    private Instant updatedAt;
    private String userId;
}

@Data
class Ingredient {
    private String name;
    private Double quantity;
    private String unit; // TODO: use Enum
}