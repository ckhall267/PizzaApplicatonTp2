package com.example.pizzaapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PizzaDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        ImageView imagePizza = findViewById(R.id.image_pizza_detail);
        TextView nomPizza = findViewById(R.id.nom_pizza_detail);
        TextView descriptionPizza = findViewById(R.id.description_pizza);
        TextView ingredientsPizza = findViewById(R.id.ingredients_pizza);
        TextView preparationPizza = findViewById(R.id.preparation_pizza);

        Intent intent = getIntent();
        if (intent == null) {
            Log.e("PizzaDetailActivity", "Intent is null!");
            return;
        }

        int image = intent.getIntExtra("image", -1);
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        String ingredients = intent.getStringExtra("ingredients");
        String preparation = intent.getStringExtra("preparation");

        if (image == -1) {
            image = R.mipmap.ic_launcher;
        }
        if (name == null) name = "Unknown Pizza";
        if (description == null) description = "No description available.";
        if (ingredients == null) ingredients = "Ingredients not available.";
        if (preparation == null) preparation = "Preparation steps not available.";

        imagePizza.setImageResource(image);
        nomPizza.setText(name);
        descriptionPizza.setText(description);
        ingredientsPizza.setText(ingredients);
        preparationPizza.setText(preparation);
    }
}
