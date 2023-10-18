package com.imt.framework.com.Uber.controller;

import com.imt.framework.com.Uber.model.Plat;
import com.imt.framework.com.Uber.repository.PlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("plat")
public class PlatController {
    @Autowired
    private PlatRepository platRepository;

    @GetMapping
    public List<Plat> getPlat(@RequestParam("maxPrix")Double maxPrix){
        if (maxPrix != null){
            return platRepository.getPlatWithMaxPriceFilter(maxPrix);
        }
        return platRepository.findAll();
    }

    @PostMapping
    public void createPlat(@RequestBody Plat plat){
        platRepository.save(plat);
    }

    @PutMapping("/{platId}")
    public void updatePlat(@PathVariable("platId") long id, @RequestBody Plat plat) throws Exception{
        Optional<Plat> searchedPlat = platRepository.findById(id);
        if (!searchedPlat.isEmpty()){
            Plat platToUpdate = searchedPlat.get();

            platToUpdate.setNom(plat.getNom());
            platToUpdate.setCalories(plat.getCalories());
            platToUpdate.setChef(plat.getChef());
            platToUpdate.setDescription(plat.getDescription());
            platToUpdate.setPrix(plat.getPrix());
            platToUpdate.setOrigine(plat.getOrigine());
            platToUpdate.setSante(plat.getSante());
            platToUpdate.setCategorie(plat.getCategorie());
            platRepository.save(platToUpdate);
        }else {
            throw new Exception(" plat inconnu");
        }
    }

    @DeleteMapping("/{platId}")
    public void deletePlat(@PathVariable("platId") long id){
        platRepository.deleteById(id);
    }
}