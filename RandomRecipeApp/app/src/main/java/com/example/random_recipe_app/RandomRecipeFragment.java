package com.example.random_recipe_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RandomRecipeFragment extends Fragment {
    Button click;
    public static TextView RecipeName_TextView;
    public static ImageView RecipeThumbnail_ImageView;

    public RandomRecipeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentRandomRecipe = inflater.inflate(R.layout.fragment_random_recipe, container, false);

        click = (Button) fragmentRandomRecipe.findViewById(R.id.random_recipe_button);
        RecipeName_TextView = (TextView) fragmentRandomRecipe.findViewById(R.id.recipe_name);
        RecipeThumbnail_ImageView = (ImageView) fragmentRandomRecipe.findViewById(R.id.recipe_thumbnail_image);

        return fragmentRandomRecipe;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchRecipeData process = new fetchRecipeData();
                process.execute();
            }
        });
    }
}