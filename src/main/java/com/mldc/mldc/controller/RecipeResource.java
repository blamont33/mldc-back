package com.mldc.mldc.controller;

import com.mldc.mldc.DTO.RecipeDTO;
import com.mldc.mldc.Model.Recipe;
import com.mldc.mldc.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeResource {
    private final RecipeService recipeService;

    @Autowired
    public RecipeResource(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    
    @PostMapping("add")
    public ResponseEntity<Recipe>addRecipe(@RequestBody RecipeDTO recipe) {
        Recipe newRecipe = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
    }
}
