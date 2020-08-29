package com.example.random_recipe_app;

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
    String recipeName = "";

    @Override
    protected Object doInBackground(Object[] objects) {
        try {

            //adapted from Abhishek Panwar's JSON Data Fetching & Parsing Tutorial: https://www.youtube.com/watch?v=Vcn4OuV4Ixg

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

            JSONObject JO = new JSONObject(data);
            JSONArray recipes = JO.getJSONArray("meals");

            for (int i=0; i < recipes.length(); i++) {
                JSONObject recipe = (JSONObject) recipes.get(i);
                recipeName = (String) recipe.get("strMeal") ;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        MainActivity.RecipeName_TextView.setText(this.recipeName);
    }
}
