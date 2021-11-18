package com.mldc.mldc.service;

import com.mldc.mldc.DTO.RecipeDTO;
import com.mldc.mldc.Model.Recipe;
import com.mldc.mldc.Model.RecipeIngredient;
import com.mldc.mldc.repository.RecipeIngredientRepo;
import com.mldc.mldc.repository.RecipeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private final RecipeRepo recipeRepo;
    private final RecipeIngredientRepo recipeIngredientRepo;

    @Autowired
    public RecipeService(RecipeRepo recipeRepo, RecipeIngredientRepo recipeIngredientRepo) {
        this.recipeRepo = recipeRepo;
        this.recipeIngredientRepo = recipeIngredientRepo;
    }

    // create recipe
    public Recipe addRecipe(RecipeDTO recipe) {
        Recipe newRecipe = new Recipe(recipe.getName(), recipe.getLink(), recipe.getNbParts(), recipe.getMaking(), recipe.getCalorie());
        Recipe savedRecipe = this.recipeRepo.save(newRecipe);

        for (RecipeIngredient i : recipe.getIngredients()) {
            this.recipeIngredientRepo.save(new RecipeIngredient(i.getIngredient(), savedRecipe, i.getQuantity(), i.getMeasure()));
        }

        return savedRecipe;
    }
}
