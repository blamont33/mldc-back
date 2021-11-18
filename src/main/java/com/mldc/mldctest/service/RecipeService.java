package com.mldc.mldctest.service;

import com.mldc.mldctest.DTO.RecipeDTO;
import com.mldc.mldctest.Model.Recipe;
import com.mldc.mldctest.Model.RecipeIngredient;
import com.mldc.mldctest.repository.RecipeIngredientRepo;
import com.mldc.mldctest.repository.RecipeRepo;

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
