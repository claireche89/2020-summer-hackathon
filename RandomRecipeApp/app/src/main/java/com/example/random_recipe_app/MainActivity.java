package com.example.random_recipe_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RandomRecipeFragment firstFragment = new RandomRecipeFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout, firstFragment).addToBackStack(null).commit();

    }

}