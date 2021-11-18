package com.mldc.mldcBack.repository;

import com.mldc.mldcBack.Model.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Long>{
    
}
