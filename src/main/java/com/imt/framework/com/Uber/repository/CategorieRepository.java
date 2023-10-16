package com.imt.framework.com.Uber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.imt.framework.com.Uber.model.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
