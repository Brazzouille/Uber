package com.imt.framework.com.Uber.entities;
import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Categorie {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nom")
    private String nom;

    @ManyToMany(mappedBy = "categories")
    private Set<Plat> plats;

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

    public Set<Plat> getPlats() {
        return plats;
    }

    public void setPlats(Set<Plat> plats) {
        this.plats = plats;
    }
}

