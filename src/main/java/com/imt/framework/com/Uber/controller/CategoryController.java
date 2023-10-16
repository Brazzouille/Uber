package com.imt.framework.com.Uber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.imt.framework.com.Uber.service.CategorieService;
import com.imt.framework.com.Uber.model.Categorie;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategoryController {
    @Autowired
    private CategorieService categorieService;

    @PostMapping("/createcategorie")
    public void creerCategorie(@RequestBody Categorie categorie){
        categorieService.creerCategorie(categorie);
    }

    @GetMapping("/listcategories")
    public List<Categorie> listCategories(){
        return categorieService.listCategories();
    }

    @PutMapping("/updatecategorie/{nomCat}")
    public void updateCategorie(@PathVariable("idCat") Long idCat, @RequestBody Categorie categorie){
        categorieService.updateCategorie(idCat, categorie);
    }
}
