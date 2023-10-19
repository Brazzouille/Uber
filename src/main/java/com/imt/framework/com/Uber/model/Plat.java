package com.imt.framework.com.Uber.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plat {
    @Id
    @GeneratedValue
    private Long platId;

    @NotNull(message = "Le nom du plat est requis.")
    private String nom;

    private String calories;

    private String description;

    private String chef;

    private Double prix;

    private String origine;

    private String sante;

    private String image;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    public enum Categorie {
        VIANDE,
        VEGAN
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "plat_id")
    private Set<Allergene> allergenes;

}
