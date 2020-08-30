package com.example.random_recipe_app;

import android.graphics.Bitmap;

public class Recipe {

    String recipeName = "";
    String thumbnailURL = "";
    String instruction = "";
    Bitmap thumbnailBMP = null;

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
