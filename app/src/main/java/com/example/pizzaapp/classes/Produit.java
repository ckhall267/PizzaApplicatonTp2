package com.example.pizzaapp.classes;

public class Produit {
    private static int idCounter = 0;
    private int id;
    private String nom;
    private int prix;
    private int image;
    private String temps;
    private String ingredients;
    private String description;
    private String etapes;

    public Produit(String nom, int prix, int image, String temps, String ingredients, String description, String etapes) {
        this.id = ++idCounter;
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.temps = temps;
        this.ingredients = ingredients;
        this.description = description;
        this.etapes = etapes;
    }

    public Produit() {}

    public int getId() { return id; }
    public String getNom() { return nom; }
    public int getPrix() { return prix; }
    public int getImage() { return image; }
    public String getTemps() { return temps; }
    public String getIngredients() { return ingredients; }
    public String getDescription() { return description; }
    public String getEtapes() { return etapes; }

    @Override
    public String toString() {
        return nom + " - " + prix + "€";
    }
}
