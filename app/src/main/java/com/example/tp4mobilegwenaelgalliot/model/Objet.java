package com.example.tp4mobilegwenaelgalliot.model;

public class Objet {
    private String nom;
    private String categorie;
    private Double prix;
    private Number qtt;

    public Objet(String nom, String categorie, Double prix, Number qtt){
     this.nom = nom;
     this.categorie = categorie;
     this.prix = prix;
     this.qtt = qtt;
    }


    public Objet(){

    }

    public String getNom() { return nom; }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Number getQtt() {   return qtt; }

    public void setQtt(Number qtt) {   this.qtt = qtt; }
}