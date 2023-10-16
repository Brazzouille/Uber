package com.imt.framework.com.Uber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imt.framework.com.Uber.repository.CategorieRepository;
import com.imt.framework.com.Uber.model.Categorie;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;
    public void creerCategorie(Categorie categorie) {
        categorieRepository.save(categorie);
    }

    public List<Categorie> listCategories() {
        return categorieRepository.findAll();
    }

    public void updateCategorie(Long idCat, Categorie categorie) {
        Categorie categorie0 = categorieRepository.findById(idCat).orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
        categorie0.setNomCat(categorie.getNomCat());
        categorie0.setDescription(categorie.getDescription());
        categorie0.setImageCat(categorie.getImageCat());
        categorieRepository.save(categorie);
    }

}
