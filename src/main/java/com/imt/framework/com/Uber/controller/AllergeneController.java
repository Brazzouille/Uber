package com.imt.framework.com.Uber.controller;

import com.imt.framework.com.Uber.model.Allergene;
import com.imt.framework.com.Uber.repository.AllergeneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("allergene")
public class AllergeneController {
    @Autowired
    private AllergeneRepository allergeneRepository;

    @GetMapping
    public List<Allergene> getAllAllergenes(){
        return allergeneRepository.findAll();
    }

    @PostMapping
    public void createAllergene(@RequestBody Allergene allergene){
        allergeneRepository.save(allergene);
    }

    @PutMapping("/{allergeneId}")
    public void updateAllergene(@PathVariable("allergeneId") long id, @RequestBody Allergene allergene) throws Exception{
        Optional<Allergene> searchedAllergene = allergeneRepository.findById(id);
        if (!searchedAllergene.isEmpty()){
            Allergene allergeneToUpdate = searchedAllergene.get();

            allergeneToUpdate.setNom(allergene.getNom());

            allergeneRepository.save(allergeneToUpdate);
        }else {
            throw new Exception("Allergène inconnu");
        }
    }

    @DeleteMapping("/{allergeneId}")
    public void deleteAllergene(@PathVariable("allergeneId") long allergeneId){
        allergeneRepository.deleteById(allergeneId);
    }
}

