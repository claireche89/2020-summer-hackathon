package com.example.random_recipe_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment_recipe_details extends Fragment {

    public static TextView Recipe_TextView;


    public fragment_recipe_details() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentRecipeDetails = inflater.inflate(R.layout.fragment_recipe_details, container, false);


        Recipe_TextView = (TextView) fragmentRecipeDetails.findViewById(R.id.textViewRecipe);



        return fragmentRecipeDetails;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }
}
