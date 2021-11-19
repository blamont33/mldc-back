package com.mldc.mldcBack.interfaces;

import com.mldc.mldcBack.Enum.Measure;

public interface RecipeIngredientProjection {

    IngredientProjection getIngredient();

    Measure getMeasure();

    float getQuantity();
}
