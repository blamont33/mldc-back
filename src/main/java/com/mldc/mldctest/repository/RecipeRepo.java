package com.mldc.mldctest.repository;

import com.mldc.mldctest.Model.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Long>{
    
}
