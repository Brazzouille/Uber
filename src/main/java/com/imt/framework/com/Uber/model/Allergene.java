package com.imt.framework.com.Uber.entities;

import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Allergene {
    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    // Constructeurs, getters, setters

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
}
