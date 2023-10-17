package com.imt.framework.com.Uber.model;

import java.util.Set;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Allergene {
    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    // Constructeurs, getters, setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
