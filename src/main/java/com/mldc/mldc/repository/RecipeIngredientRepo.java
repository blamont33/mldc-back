package com.mldc.mldc.repository;

import com.mldc.mldc.Model.RecipeIngredient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepo extends JpaRepository<RecipeIngredient, Long>{
    
}
