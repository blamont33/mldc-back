package com.mldc.mldcBack.repository;

import java.util.List;
import java.util.Optional;

import com.mldc.mldcBack.Model.Ingredient;
import com.mldc.mldcBack.interfaces.IngredientProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient, Long> {

    Optional<Ingredient> findByName(String name);

    @Query("Select i from Ingredient i")
    List<IngredientProjection> getAllIngredients();
}
