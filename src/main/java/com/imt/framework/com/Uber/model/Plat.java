package com.imt.framework.com.Uber.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plat {
    @Id
    @GeneratedValue
    private Long platId;

    private String nom;

    private String calories;

    private String description;

    private String chef;

    private Double prix;

    private String origine;

    private String sante;

    private String image;

    private String categorie;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "plat_allergene",
            joinColumns = @JoinColumn(name = "plat_id"),
            inverseJoinColumns = @JoinColumn(name = "allergene_id"))
    private Set<Allergene> allergenes = new HashSet<>();
}
