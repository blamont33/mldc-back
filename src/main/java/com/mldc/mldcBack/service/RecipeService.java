package com.mldc.mldcBack.service;

import java.util.List;

import com.mldc.mldcBack.DTO.RecipeDTO;
import com.mldc.mldcBack.Model.Recipe;
import com.mldc.mldcBack.Model.RecipeIngredient;
import com.mldc.mldcBack.interfaces.RecipeProjection;
import com.mldc.mldcBack.repository.RecipeIngredientRepo;
import com.mldc.mldcBack.repository.RecipeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Recipe newRecipe = new Recipe(recipe.getName(), recipe.getLink(), recipe.getNbParts(), recipe.getMaking(),
                recipe.getCalorie());
        Recipe savedRecipe = recipeRepo.save(newRecipe);

        for (RecipeIngredient i : recipe.getIngredients()) {
            this.recipeIngredientRepo
                    .save(new RecipeIngredient(i.getIngredient(), savedRecipe, i.getQuantity(), i.getMeasure()));
        }

        return savedRecipe;
    }

    // Get recipes
    @Transactional
    public List<RecipeProjection> getRecipes() {
        return recipeRepo.getAllRecipes();
    }
}
