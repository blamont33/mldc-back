package com.mldc.mldc.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mldc.mldc.Enum.Measure;

@Entity
@Table
public class RecipeIngredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    private Ingredient ingredient;

    @ManyToOne
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