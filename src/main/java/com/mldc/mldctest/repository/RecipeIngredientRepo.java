package com.mldc.mldctest.repository;

import com.mldc.mldctest.Model.RecipeIngredient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepo extends JpaRepository<RecipeIngredient, Long>{
    
}
