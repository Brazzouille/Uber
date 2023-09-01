package com.imt.framework.com.Uber.entities;
import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Plat {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "calories")
    private String calories;

    @Column(name = "description")
    private String description;

    @Column(name = "chef")
    private String chef;

    @Column(name = "prix")
    private Double prix;

    @Column(name = "origine")
    private String origine;

    @Column(name = "sante")
    private String sante;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChef() {
        return chef;
    }

    public void setChef(String chef) {
        this.chef = chef;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getSante() {
        return sante;
    }

    public void setSante(String sante) {
        this.sante = sante;
    }
}
