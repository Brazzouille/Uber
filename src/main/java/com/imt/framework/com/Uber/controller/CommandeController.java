package com.imt.framework.com.Uber.controller;

import com.imt.framework.com.Uber.dto.CommandePlatDto;
import com.imt.framework.com.Uber.model.Commande;
import com.imt.framework.com.Uber.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @PostMapping("/create-commande")
    public ResponseEntity<Commande> createCommande(@RequestBody List<CommandePlatDto> commandePlatsDto, @RequestParam Long userId, @RequestParam String adresse) {
        try {
            Commande commande = commandeService.createCommande(userId, commandePlatsDto, adresse);
            return ResponseEntity.ok(commande);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/afficher-commande-en-cours")
    public List<Commande> afficherCommandeEnCours(@RequestParam Long userId) {
        return commandeService.afficherCommandeEnCours(userId);
    }

    //Historique des commandes
    @GetMapping("/afficher-commande-terminee")
    public List<Commande> afficherCommandeTerminee(@RequestParam Long userId) {
            return commandeService.afficherCommandeTerminee(userId);
    }

    //Lorsque l'utilisateur confirme que la commande est récupérée
    @PostMapping("/commande-recuperee")
    public ResponseEntity<Commande> commandeRecuperee(@RequestParam Long commandeId) {
        try {
            Commande commande = commandeService.commandeRecuperee(commandeId);
            return ResponseEntity.ok(commande);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}


