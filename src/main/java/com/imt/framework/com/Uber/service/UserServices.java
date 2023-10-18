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
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            throw new RuntimeException("Le compte existe déjà");
        }else{
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setPassword(password);
            newUser.setCrousCardBalance(0.0);
            userRepository.save(newUser);
            System.out.println("Le compte a été créé");
        }
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

    public void rechargerCarte(String email, String password, Double amount) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                user.get().setCrousCardBalance(user.get().getCrousCardBalance() + amount);
                userRepository.save(user.get());
            } else {
                System.out.println("Le mot de passe est incorrect");
            }
        } else {
            System.out.println("Le compte n'existe pas, veuillez créer un compte");
        }
    }
}
