package com.mldc.mldcBack.repository;

import com.mldc.mldcBack.Model.RecipeIngredient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepo extends JpaRepository<RecipeIngredient, Long> {

}
