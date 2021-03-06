package com.mldc.mldcBack.controller;

import java.util.List;

import com.mldc.mldcBack.Model.Ingredient;
import com.mldc.mldcBack.interfaces.IngredientProjection;
import com.mldc.mldcBack.service.IngredientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredient")
public class IngredientResource {
    private final IngredientService ingredientService;

    @Autowired
    public IngredientResource(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<IngredientProjection>> getIngredients() {
        List<IngredientProjection> ingredients = ingredientService.getIngredients();
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) {
        Ingredient newIngredient = ingredientService.addIngredient(ingredient);
        return new ResponseEntity<>(newIngredient, HttpStatus.CREATED);
    }

    @GetMapping("/byRecipe/{id}")
    public ResponseEntity<List<IngredientProjection>> getIngrendientsByRecipe(@PathVariable("id") Long id) {
        List<IngredientProjection> ingredientList = ingredientService.getIngrendientsByRecipe(id);
        return new ResponseEntity<>(ingredientList, HttpStatus.OK);
    }

}
