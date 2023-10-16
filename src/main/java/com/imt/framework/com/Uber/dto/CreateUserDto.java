package com.imt.framework.com.Uber.dto;

import lombok.Data;

@Data
public class CreateUserDto {
    private String firstName;

    private String lastName;

    private String email;

    private String password;

}
