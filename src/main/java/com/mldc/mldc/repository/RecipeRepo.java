package com.mldc.mldc.repository;

import com.mldc.mldc.Model.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Long>{
    
}
