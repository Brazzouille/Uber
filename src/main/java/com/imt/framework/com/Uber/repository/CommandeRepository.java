package com.imt.framework.com.Uber.repository;

import com.imt.framework.com.Uber.model.Commande;
import com.imt.framework.com.Uber.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

    List<Commande> findAllByUserAndStatusOrderByDateCreeDesc(User user, Commande.Status status);
}
