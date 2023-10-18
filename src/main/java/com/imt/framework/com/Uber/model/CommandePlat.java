package com.imt.framework.com.Uber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandePlat {
    @Id
    @GeneratedValue
    private Long idCmdPlat;

    @ManyToOne
    @JoinColumn(name = "platId")
    private Plat plat;

    @Column(nullable = false)
    private double prix;

    @Column(nullable = false)
    private int quantite;

}
