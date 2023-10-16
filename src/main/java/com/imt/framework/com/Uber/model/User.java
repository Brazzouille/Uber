package com.imt.framework.com.Uber.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Double crousCardBalance;

}
