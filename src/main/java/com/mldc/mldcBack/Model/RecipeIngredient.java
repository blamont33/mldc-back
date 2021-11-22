package com.mldc.mldcBack.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mldc.mldcBack.Enum.Measure;

@Entity
@Table
public class RecipeIngredient implements Serializable {

    @Id
    @SequenceGenerator(name = "recipeIngredient_sequence", sequenceName = "recipeIngredient_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipeIngredient_sequence")
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("recipeIngredients")
    private Ingredient ingredient;

    @ManyToOne
    @JsonIgnoreProperties("recipeIngredients")
    private Recipe recipe;

    private float quantity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Measure measure;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Ingredient ingredient, Recipe recipe, float quantity, Measure measure) {
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.quantity = quantity;
        this.measure = measure;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }


    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    @Override
    public String toString() {
        return "RecipeIngredient [ingredient=" + ingredient + ", measure=" + measure + ", quantity=" + quantity
                + ", recipe=" + recipe + "]";
    }

}
