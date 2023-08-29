package com.imt.framework.com.Uber.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

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


}
