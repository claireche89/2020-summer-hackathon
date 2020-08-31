package com.example.random_recipe_app;

import android.graphics.Bitmap;

public class Recipe {

    String recipeName = "";
    String thumbnailURL = "";
    String instruction = "";
    Bitmap thumbnailBMP = null;

    public String[] getIngredient() {
        return ingredient;
    }

    public void setIngredient(String[] ingredient) {
        this.ingredient = ingredient;
    }

    String ingredient[] = null;


    public String[] getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String[] measurement) {
        this.measurement = measurement;
    }

    String measurement[] = null;

    public Recipe() {

    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public String getInstruction() {
        return instruction;
    }

    public Bitmap getThumbnailBMP() {
        return thumbnailBMP;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setThumbnailBMP(Bitmap thumbnailBMP) {
        this.thumbnailBMP = thumbnailBMP;
    }

}
