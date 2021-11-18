package com.mldc.mldc.repository;

import java.util.Optional;

import com.mldc.mldc.Model.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepo extends JpaRepository<Ingredient, Long>{

    Optional<Ingredient> findByName(String name);
    
}
