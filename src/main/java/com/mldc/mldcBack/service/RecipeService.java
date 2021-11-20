package com.mldc.mldcBack.service;

import java.util.List;

import com.mldc.mldcBack.DTO.RecipeDTO;
import com.mldc.mldcBack.Model.Recipe;
import com.mldc.mldcBack.Model.RecipeIngredient;
import com.mldc.mldcBack.interfaces.RecipeProjection;
import com.mldc.mldcBack.repository.RecipeIngredientRepo;
import com.mldc.mldcBack.repository.RecipeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
    @Transactional
    public Recipe addRecipe(RecipeDTO recipe) {
        if (recipe.getName() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le nom est obligatoire");
        } else if (recipe.getNbParts() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le nombre de parts est obligatoire");
        } else {
            Recipe newRecipe = new Recipe(recipe.getName(), recipe.getLink(), recipe.getNbParts(), recipe.getMaking(),
                    recipe.getCalorie());
            Recipe savedRecipe = recipeRepo.save(newRecipe);

            for (RecipeIngredient i : recipe.getIngredients()) {
                recipeIngredientRepo
                        .save(new RecipeIngredient(i.getIngredient(), savedRecipe, i.getQuantity(), i.getMeasure()));
            }

            return savedRecipe;
        }
    }

    // Get all recipes
    @Transactional
    public List<RecipeProjection> getRecipes() {
        return recipeRepo.getAllRecipes();
    }

    // Get recipes by id
    @Transactional
    public List<RecipeProjection> getRecipesById(List<Long> id) {
        return recipeRepo.getRecipesById(id);
    }

    // Delete recipe
    public void deleteRecipe(Long id) {
        recipeRepo.deleteById(id);
        ;
    }
}
