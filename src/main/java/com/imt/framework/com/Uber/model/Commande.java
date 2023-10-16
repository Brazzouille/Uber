package com.imt.framework.com.Uber.model;

import jakarta.persistence.Enumerated;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    enum Status {
        EN_ATTENTE,
        EN_COURS,
        TERMINE,
        ANNULE
    }
}
