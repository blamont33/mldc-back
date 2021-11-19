package com.mldc.mldcBack.controller;

import java.util.List;

import com.mldc.mldcBack.DTO.RecipeDTO;
import com.mldc.mldcBack.Model.Recipe;
import com.mldc.mldcBack.interfaces.RecipeProjection;
import com.mldc.mldcBack.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public ResponseEntity<List<RecipeProjection>> getRecipes() {
        List<RecipeProjection> listRecipe = recipeService.getRecipes();
        return new ResponseEntity<>(listRecipe, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Recipe> addRecipe(@RequestBody RecipeDTO recipe) {
        Recipe newRecipe = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
    }
}
