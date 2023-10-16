package com.imt.framework.com.Uber.model;

import jakarta.persistence.Enumerated;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String adresse;

    //@OneToMany(mappedBy = "idCmdPlat.commande",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //private List<Plat> commandePlats;



    enum Status {
        EN_ATTENTE,
        EN_COURS,
        TERMINE,
        ANNULE
    }
}
