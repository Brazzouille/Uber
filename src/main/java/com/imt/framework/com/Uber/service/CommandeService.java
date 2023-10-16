package com.imt.framework.com.Uber.service;

import com.imt.framework.com.Uber.dto.CommandePlatDto;
import com.imt.framework.com.Uber.model.*;
import com.imt.framework.com.Uber.repository.CommandePlatRepository;
import com.imt.framework.com.Uber.repository.CommandeRepository;
import com.imt.framework.com.Uber.repository.PlatRepository;
import com.imt.framework.com.Uber.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private CommandePlatRepository commandePlatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlatRepository platRepository;

    @Transactional
    public Commande createCommande(Long userId, List<CommandePlatDto> commandePlatsDto){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Utilisateur non trouvée"));

        double prixTotal = commandePlatsDto.stream()
                .mapToDouble(dto -> {
                    Plat plat = platRepository.findById(dto.getPlatId()).orElseThrow(() -> new RuntimeException("Plat non trouvé"));
                    return plat.getPrix() * dto.getQuantite();
                })
                .sum();

        if(prixTotal == 0){
            throw new RuntimeException("Le prix total ne peut pas être égal à 0");
        }else if(prixTotal > user.getCrousCardBalance()){
            throw new RuntimeException("La solde de carte Crous est insuffisante");
        }

        Commande commande = new Commande();
        commande.setUser(user);
        commande.setStatus(Commande.Status.EN_COURS);
        commande.setDateCree(LocalDateTime.now());
        commande.setDateMaj(LocalDateTime.now());
        commande.setPrixTotal(prixTotal);
        List<CommandePlat> commandePlats = new ArrayList<>();

        commandePlatsDto.forEach(dto -> {
            CommandePlat commandePlat = new CommandePlat();
            Plat plat = platRepository.findById(dto.getPlatId()).orElseThrow(() -> new RuntimeException("Plat non trouvé"));
            commandePlat.setPlat(plat);
            commandePlat.setQuantite(dto.getQuantite());
            commandePlat.setPrix(plat.getPrix());
            commandePlats.add(commandePlat);
        });

        commande.setCommandePlats(commandePlats);
        return commandeRepository.save(commande);
    }
}
