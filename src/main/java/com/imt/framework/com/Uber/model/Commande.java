package com.imt.framework.com.Uber.model;

import jakarta.persistence.Enumerated;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "L'adresse est requise.")
    private String adresse;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cmdId")
    private List<CommandePlat> commandePlats;

    private Double prixTotal;

    public enum Status {
        EN_COURS,
        TERMINEE
    }
}
