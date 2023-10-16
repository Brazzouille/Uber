package com.imt.framework.com.Uber.service;

import com.imt.framework.com.Uber.model.User;
import com.imt.framework.com.Uber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public void createUser(String email, String firstName, String lastName, String password) {
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setCrousCardBalance(0.0);
        userRepository.save(user);
    }

    public boolean signIn(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                System.out.println("Connexion réussie");
                return true;
            } else {
                System.out.println("Wrong password");
                return false;
            }
        } else {
            System.out.println("Le compte n'existe pas, veuillez créer un compte");
            return false;
        }
    }

}
