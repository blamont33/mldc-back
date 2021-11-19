package com.mldc.mldcBack.interfaces;

import java.util.List;

public interface RecipeProjection {
    Long getId();

    String getName();

    String getLink();

    String getMaking();

    int getCalorie();

    List<RecipeIngredientProjection> getRecipeIngredients();
}
