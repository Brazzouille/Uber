package com.imt.framework.com.Uber.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Categorie {
    @Id
    private String nom;
    private String description;

    public Categorie(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public Categorie() {
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
