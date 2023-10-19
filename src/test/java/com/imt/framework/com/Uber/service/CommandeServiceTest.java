package com.imt.framework.com.Uber.service;

import com.imt.framework.com.Uber.dto.CommandePlatDto;
import com.imt.framework.com.Uber.model.*;
import com.imt.framework.com.Uber.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommandeServiceTest {

    @Mock
    private CommandeRepository commandeRepository;

    @Mock
    private CommandePlatRepository commandePlatRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PlatRepository platRepository;

    @InjectMocks
    private CommandeService commandeService;

    private User user;
    private Plat plat;
    private CommandePlatDto commandePlatDto;
    private Commande commandeTerminee;
    private Commande commandeEnCours;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUserId(1L);
        user.setCrousCardBalance(100.0);

        plat = new Plat();
        plat.setPrix(20.0);

        commandePlatDto = new CommandePlatDto();
        commandePlatDto.setPlatId(1L);
        commandePlatDto.setQuantite(1);

        commandeTerminee = new Commande();
        commandeTerminee.setStatus(Commande.Status.TERMINEE);

        commandeEnCours = new Commande();
        commandeEnCours.setStatus(Commande.Status.EN_COURS);
    }

    @Test
    void createCommandeSuccess() {
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        when(platRepository.findById(any(Long.class))).thenReturn(Optional.of(plat));
        when(commandeRepository.save(any(Commande.class))).thenAnswer(i -> i.getArguments()[0]); // return the same object

        Commande result = commandeService.createCommande(1L, Collections.singletonList(commandePlatDto), "Some address");

        assertNotNull(result);
        assertNotNull(result.getUser());
        assertNotNull(result.getCommandePlats());
    }

    @Test
    void givenUserWhenAfficherCommandeTermineeThenReturnList() {
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        when(commandeRepository.findAllByUserAndStatusOrderByDateCreeDesc(user, Commande.Status.TERMINEE))
                .thenReturn(Collections.singletonList(commandeTerminee));

        List<Commande> result = commandeService.afficherCommandeTerminee(user.getUserId());

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(Commande.Status.TERMINEE, result.get(0).getStatus());
    }

    @Test
    void givenUserWhenAfficherCommandeEnCoursThenReturnList() {
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        when(commandeRepository.findAllByUserAndStatusOrderByDateCreeDesc(user, Commande.Status.EN_COURS))
                .thenReturn(Collections.singletonList(commandeEnCours));

        List<Commande> result = commandeService.afficherCommandeEnCours(user.getUserId());

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(Commande.Status.EN_COURS, result.get(0).getStatus());
    }

    @Test
    void givenInvalidUserIdWhenAfficherCommandeThenThrowException() {
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        Exception exceptionTerminee = assertThrows(RuntimeException.class, () -> {
            commandeService.afficherCommandeTerminee(99L);
        });

        assertEquals("Utilisateur non trouvée", exceptionTerminee.getMessage());

        Exception exceptionEnCours = assertThrows(RuntimeException.class, () -> {
            commandeService.afficherCommandeEnCours(99L);
        });

        assertEquals("Utilisateur non trouvée", exceptionEnCours.getMessage());
    }

}
