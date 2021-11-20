package com.mldc.mldcBack.repository;

import java.util.List;

import com.mldc.mldcBack.Model.Recipe;
import com.mldc.mldcBack.interfaces.RecipeProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {

    @Query("Select r from Recipe r")
    List<RecipeProjection> getAllRecipes();

    @Query("SELECT r from Recipe r WHERE r.id in (?1)")
    List<RecipeProjection> getRecipesById(List<Long> id);
}
