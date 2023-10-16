package com.imt.framework.com.Uber.controller;

import com.imt.framework.com.Uber.dto.CreateUserDto;
import com.imt.framework.com.Uber.dto.SignInDto;
import com.imt.framework.com.Uber.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @PutMapping("/create-user")
    private void createUser(@RequestBody CreateUserDto createUserDto) {
        userServices.createUser(createUserDto.getEmail(), createUserDto.getFirstName(), createUserDto.getLastName(), createUserDto.getPassword());
    }

    @PostMapping("/sign-in")
    private boolean signIn(@RequestBody SignInDto signInDto) {
        return userServices.signIn(signInDto.getEmail(), signInDto.getPassword());
    }
}
