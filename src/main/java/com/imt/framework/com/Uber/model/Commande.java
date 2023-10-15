package com.imt.framework.com.Uber.model;

import jakarta.persistence.Enumerated;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cmdId;

    private LocalDateTime dateCree;

    private LocalDateTime dateMaj;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Long userid;

    private String adresse;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    enum Status {
        EN_ATTENTE,
        EN_COURS,
        TERMINE,
        ANNULE
    }

    public Long getCmdId() {
        return cmdId;
    }

    public void setCmdId(Long cmdId) {
        this.cmdId = cmdId;
    }

    public LocalDateTime getDateCree() {
        return dateCree;
    }

    public void setDateCree(LocalDateTime dateCree) {
        this.dateCree = dateCree;
    }

    public LocalDateTime getDateMaj() {
        return dateMaj;
    }

    public void setDateMaj(LocalDateTime dateMaj) {
        this.dateMaj = dateMaj;
    }


}
