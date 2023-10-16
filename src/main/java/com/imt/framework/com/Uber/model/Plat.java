package com.imt.framework.com.Uber.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}