package com.mldc.mldctest.DTO;

import java.util.List;

import javax.persistence.Lob;

import com.mldc.mldctest.Enum.Measure;
import com.mldc.mldctest.Model.RecipeIngredient;

public class RecipeDTO {
    private String name;
    private String link;
    private int nbParts;
    @Lob
    private String making;
    private int calorie;
    private List<RecipeIngredient> ingredients;
    private float quantity;
    private Measure measure;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getNbParts() {
        return nbParts;
    }

    public void setNbParts(int nbParts) {
        this.nbParts = nbParts;
    }

    public String getMaking() {
        return making;
    }

    public void setMaking(String making) {
        this.making = making;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
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
}
