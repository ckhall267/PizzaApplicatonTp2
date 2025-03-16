package com.example.pizzaapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzaapp.adapter.PizzaAdapter;
import com.example.pizzaapp.classes.Produit;
import com.example.pizzaapp.services.ProduitService;
import java.util.List;

public class ListPizzaActivity extends AppCompatActivity {
    private ListView listView;
    private PizzaAdapter adapter;
    private ProduitService produitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        listView = findViewById(R.id.liste);
        produitService = new ProduitService();

        // Adding 10 pizzas with different names and long descriptions
        produitService.create(new Produit("Margherita", 8, R.mipmap.pizza1, "30 min",
                "Tomatoes, Mozzarella, Basil, Olive oil, Oregano, Fresh Dough, Garlic, Parmesan, Salt, Pepper",
                "<b>The Margherita pizza is a true classic</b>, loved by millions worldwide. It originated in Naples, Italy, and is one of the most traditional pizzas you can make. The simple combination of tomatoes, mozzarella, and basil creates an explosion of fresh flavors. The crispy yet chewy crust is the perfect base for these ingredients, and the drizzle of olive oil enhances the overall taste. Some people add a sprinkle of parmesan for an extra touch of richness.",
                "STEP 1: Preheat oven to 450°F.\nSTEP 2: Roll out fresh pizza dough evenly.\nSTEP 3: Spread homemade tomato sauce over the base.\nSTEP 4: Slice fresh mozzarella and place it evenly.\nSTEP 5: Add basil leaves and drizzle olive oil.\nSTEP 6: Sprinkle oregano and a pinch of salt.\nSTEP 7: Bake for 15 minutes until golden brown.\nSTEP 8: Remove from oven, let it cool slightly, and enjoy."));

        produitService.create(new Produit("Pepperoni Blast", 9, R.mipmap.pizza2, "35 min",
                "Pepperoni slices, Mozzarella, Tomato sauce, Garlic, Chili flakes, Red Onions, Oregano, Black Pepper, Olive Oil",
                "<b>Pepperoni Blast is a spicy, cheesy delight</b>, featuring crispy pepperoni slices layered over gooey melted mozzarella and rich tomato sauce. The bold, smoky flavor of the pepperoni is complemented by a sprinkle of oregano and chili flakes. A perfect choice for spice lovers!",
                "STEP 1: Preheat oven to 425°F.\nSTEP 2: Spread tomato sauce on the base.\nSTEP 3: Cover with shredded mozzarella.\nSTEP 4: Arrange pepperoni slices evenly.\nSTEP 5: Sprinkle chili flakes and minced garlic.\nSTEP 6: Drizzle with olive oil.\nSTEP 7: Bake for 18 minutes until cheese is bubbling.\nSTEP 8: Slice and enjoy!"));

        String[] pizzaNames = {"BBQ Chicken Supreme", "Four Cheese Heaven", "Spicy Jalapeño", "Truffle Mushroom Delight", "Hawaiian Bliss", "Mediterranean Veggie", "Meat Lovers Special", "Garlic Parmesan"};

        for (int i = 3; i <= 10; i++) {
            produitService.create(new Produit(pizzaNames[i - 3], 12, getResources().getIdentifier("pizza" + i, "mipmap", getPackageName()), "38 min",
                    "Premium ingredients including aged cheeses, hand-picked vegetables, organic meats, truffle oil, and a special blend of herbs and spices.",
                    "<b>This pizza is a gourmet experience</b>, offering a rich combination of flavors that explode in your mouth. The blend of carefully selected cheeses creates a creamy, savory base, while the fresh toppings provide a delightful contrast. With each bite, you experience the perfect balance of textures: the crispy crust, the melted cheese, and the juicy toppings.",
                    "STEP 1: Preheat oven to 400°F.\nSTEP 2: Stretch the pizza dough onto a baking tray.\nSTEP 3: Spread a layer of homemade tomato sauce.\nSTEP 4: Generously add shredded mozzarella and specialty cheeses.\nSTEP 5: Place gourmet toppings such as truffle mushrooms, prosciutto, roasted bell peppers, and caramelized onions.\nSTEP 6: Drizzle with truffle oil and sprinkle fresh basil.\nSTEP 7: Bake for 20 minutes until the edges are crispy and golden.\nSTEP 8: Remove from oven, let it cool, slice, and enjoy a luxury pizza experience."));
        }

        List<Produit> pizzas = produitService.findAll();
        adapter = new PizzaAdapter(this, pizzas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Produit selectedPizza = (Produit) parent.getItemAtPosition(position);
            if (selectedPizza == null) {
                Log.e("ListPizzaActivity", "Selected pizza is null!");
                return;
            }

            Intent intent = new Intent(ListPizzaActivity.this, PizzaDetailActivity.class);
            intent.putExtra("image", selectedPizza.getImage());
            intent.putExtra("name", selectedPizza.getNom());
            intent.putExtra("description", selectedPizza.getDescription());
            intent.putExtra("ingredients", selectedPizza.getIngredients());
            intent.putExtra("preparation", selectedPizza.getEtapes());

            startActivity(intent);
        });

        // Handle the share button click
        ImageView shareButton = findViewById(R.id.share_button);
        shareButton.setOnClickListener(v -> {
            // Create an Intent to share pizza information
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");

            // Share a simple message (you can customize it)
            String shareMessage = "Check out these amazing pizzas! Visit our app for more details.";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);

            // Start the share intent
            startActivity(Intent.createChooser(shareIntent, "Share via"));
        });
    }
}
