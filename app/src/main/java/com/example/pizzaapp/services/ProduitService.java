package com.example.pizzaapp.services;

import com.example.pizzaapp.classes.Produit;
import com.example.pizzaapp.dao.IDao;
import java.util.ArrayList;
import java.util.List;

public class ProduitService implements IDao<Produit> {
    private List<Produit> produits = new ArrayList<>();

    @Override
    public boolean create(Produit obj) {
        return produits.add(obj);
    }

    @Override
    public boolean delete(Produit obj) {
        return produits.remove(obj);
    }

    @Override
    public boolean update(Produit obj) {
        return true;
    }

    @Override
    public Produit findById(int id) {
        return produits.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Produit> findAll() {
        return produits;
    }
}
