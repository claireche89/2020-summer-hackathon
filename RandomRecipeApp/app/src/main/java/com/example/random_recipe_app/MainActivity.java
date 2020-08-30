package com.example.random_recipe_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button click;
    public static TextView RecipeName_TextView;
    public static ImageView RecipeThumbnail_ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.random_recipe_button);
        RecipeName_TextView = (TextView) findViewById(R.id.recipe_name);
        RecipeThumbnail_ImageView = (ImageView) findViewById(R.id.recipe_thumbnail_image);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchRecipeData process = new fetchRecipeData();
                process.execute();
            }
        });
    }
}