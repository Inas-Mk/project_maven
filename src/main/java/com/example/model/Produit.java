package com.example.model;

public class Produit {

    private int id;
    private String nom;
    private int quantite;
    private double prix;

public Produit() {

}

public Produit(int id, String nom, int quantite, double prix) {
    this.id = id;
    this.nom = nom;
    this.quantite = quantite;
    this.prix = prix;
}


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }
}
