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
    public ResponseEntity<Commande> createCommande(@RequestBody List<CommandePlatDto> commandePlatsDto, @RequestParam Long userId){
        try{
            Commande commande = commandeService.createCommande(userId, commandePlatsDto);
            return ResponseEntity.ok(commande);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
