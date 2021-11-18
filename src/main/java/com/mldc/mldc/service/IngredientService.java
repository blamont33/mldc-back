package com.mldc.mldc.service;

import java.util.List;
import java.util.Optional;

import com.mldc.mldc.Model.Ingredient;
import com.mldc.mldc.repository.IngredientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    private final IngredientRepo ingredientRepo;

    @Autowired
    public IngredientService(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    // add an ingredient
    public Ingredient addIngredient(Ingredient ingredient) {
        Optional<Ingredient> ingredientOptional = ingredientRepo.findByName(ingredient.getName());

        if (ingredientOptional.isPresent()) {
            throw new IllegalStateException("Ingredient already exists");
        }
        if (ingredient.getName().length() > 0) {
            return ingredientRepo.save(ingredient);
        } else {
            throw new IllegalStateException("Ingredient name can't be null");
        }
    }

    // Get all ingredients
    public List<Ingredient> getIngredients() {
        return ingredientRepo.findAll();
    }
}