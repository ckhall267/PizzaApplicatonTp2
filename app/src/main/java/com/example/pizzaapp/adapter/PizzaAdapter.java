package com.example.pizzaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.pizzaapp.R;
import com.example.pizzaapp.classes.Produit;
import java.util.List;
import java.util.Random;


public class PizzaAdapter extends BaseAdapter {
    private Context context;
    private List<Produit> pizzas;
    private Random random = new Random(); // For generating random numbers

    public PizzaAdapter(Context context, List<Produit> pizzas) {
        this.context = context;
        this.pizzas = pizzas;
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_pizza, parent, false);
        }

        ImageView imagePizza = convertView.findViewById(R.id.image_pizza);
        TextView nomPizza = convertView.findViewById(R.id.nom_pizza);
        TextView randomNumber = convertView.findViewById(R.id.random_number);
        TextView cookingTime = convertView.findViewById(R.id.cooking_time);
        ImageView rightIcon = convertView.findViewById(R.id.middle_right_icon);

        Produit pizza = pizzas.get(position);
        imagePizza.setImageResource(pizza.getImage());
        nomPizza.setText(pizza.getNom());

        // Generate random values
        randomNumber.setText(String.valueOf(random.nextInt(9) + 1)); // 1-9
        cookingTime.setText((random.nextInt(15) + 25) + " min"); // 25-40 min

        rightIcon.setImageResource(R.drawable.img_3);

        return convertView;
    }
}
