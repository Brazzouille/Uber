package com.imt.framework.com.Uber.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandePlat {
    @EmbeddedId
    private CommandePlatId id;

    @ManyToOne
    @MapsId("cmdId")
    @JoinColumn(name = "cmdId")
    private Commande commande;

    @ManyToOne
    @MapsId("platId")
    @JoinColumn(name = "platId")
    private Plat plat;

    private double prix;
    private int quantite;

}
