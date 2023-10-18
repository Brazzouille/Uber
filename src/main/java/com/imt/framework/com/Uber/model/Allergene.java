package com.imt.framework.com.Uber.model;

import java.util.Set;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Allergene {
    @Id
    @GeneratedValue
    private Long allergeneId;

    private String nom;
}
