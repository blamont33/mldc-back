package com.mldc.mldcBack.controller;

import java.util.List;

import com.mldc.mldcBack.DTO.RecipeDTO;
import com.mldc.mldcBack.Model.Recipe;
import com.mldc.mldcBack.interfaces.RecipeProjection;
import com.mldc.mldcBack.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/byId")
    public ResponseEntity<List<RecipeProjection>> getRecipesById(@RequestParam List<Long> id) {
        List<RecipeProjection> recipe = recipeService.getRecipesById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Recipe> addRecipe(@RequestBody RecipeDTO recipe) {
        Recipe newRecipe = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable("id") Long id) {
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
