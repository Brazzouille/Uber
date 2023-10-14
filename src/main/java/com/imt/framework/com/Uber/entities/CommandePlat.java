package com.imt.framework.com.Uber.entities;

import jakarta.persistence.*;

@Entity
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

    // Constructeurs, getters, setters
    public CommandePlat() {}

    public CommandePlat(Commande commande, Plat plat) {
        this.commande = commande;
        this.plat = plat;
        this.id = new CommandePlatId(plat.getPlatId(), commande.getCmdId());
    }

    public CommandePlatId getId() {
        return id;
    }

    public void setId(CommandePlatId id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
