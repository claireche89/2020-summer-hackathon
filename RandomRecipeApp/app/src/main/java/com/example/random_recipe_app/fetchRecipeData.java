package com.example.random_recipe_app;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchRecipeData extends AsyncTask {
    String data = "";
    Recipe recipe;
    String longString="";
    String instruction="Instructions:\n";

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            //adapted from Abhishek Panwar's JSON Data Fetching & Parsing Tutorial: https://www.youtube.com/watch?v=Vcn4OuV4Ixg

            //read in data from TheMealDB JSON API: https://www.themealdb.com/api.php
            URL url = new URL("https://www.themealdb.com/api/json/v1/1/random.php");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

            //Parse through JSONObject for recipe data
            recipe = new Recipe();

            JSONObject JO = new JSONObject(data);
            JSONArray recipes = JO.getJSONArray("meals");

            for (int i=0; i < recipes.length(); i++) {
                JSONObject obj = (JSONObject) recipes.get(i);
                recipe.setRecipeName( (String) obj.get("strMeal") );
                recipe.setThumbnailURL( (String) obj.get("strMealThumb") );

                String[] ingredients=null;
                String[] measurements=null;
                longString="Ingredients: \n";
                for(int j=1; j<=20; j++){
                    longString=longString+ (String) obj.get("strMeasure"+j)+" "+(String) obj.get("strIngredient"+j)+"\n";
                }

                instruction+=(String) obj.get("strInstructions");
                recipe.setInstruction( instruction );
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //adapted from Chris Ross's Android Image Loading from a String URL tutorial: https://medium.com/@crossphd/android-image-loading-from-a-string-url-6c8290b82c5e

        //read in thumbnail image as bitmap
        try {
            InputStream in = new java.net.URL(recipe.getThumbnailURL()).openStream();
            recipe.setThumbnailBMP( BitmapFactory.decodeStream(in) );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recipe;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        RandomRecipeFragment.RecipeName_TextView.setText(recipe.getRecipeName());
        RandomRecipeFragment.RecipeThumbnail_ImageView.setImageBitmap(recipe.getThumbnailBMP());
        RandomRecipeFragment.RecipeIngredients_TextView.setText(longString);
        RandomRecipeFragment.RecipeInstructions_TextView.setText(instruction);

    }
}
