package com.imt.framework.com.Uber.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// Composite key for CommandePlat

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandePlatId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "cmdId")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "platId")
    private Plat plat;

}
