package com.cookbook.recipe.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Ingredient {

    @NotBlank(message = "Ingredient name is required")
    @Size(max = 50, message = "Ingredient name must be less than 50 characters")
    private String name;

    @NotNull(message = "Ingredient quantity is required")
    @Positive(message = "Quantity must be required")
    private Double quantity;

    @NotBlank(message = "Unit is required")
    private String unit; // TODO: use Enum
}