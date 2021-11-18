package com.mldc.mldctest.service;

import com.mldc.mldctest.Model.Recipe;
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
    public Recipe addRecipe(Recipe recipe) {
        Long recipeId = recipeRepo.save(recipe).getId();
        return 
    }
}
