package com.imt.framework.com.Uber.resources;

import com.imt.framework.com.Uber.entities.Plat;
import com.imt.framework.com.Uber.repository.PlatRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Path("plat")
public class PlatResources {
    @Autowired
    private PlatRepository platRepository;

    @GET
    @Produces( value = "application/json")
    public List<Plat> getPlat(@QueryParam("maxPrix")Double maxPrix){
        if (maxPrix != null){
            return platRepository.getPlatWithMaxPriceFilter(maxPrix);
        }
        return platRepository.findAll();
    }

    @POST
    @Consumes( value = "application/json")
    public void createPlat(@NotNull @RequestBody Plat plat){
        platRepository.save(plat);
    }

    @PUT
    @Consumes(value = "application/json")
    @Path("/{id}")
    public void updatePlat(@NotNull @PathParam("id") long id, @RequestBody Plat plat) throws Exception{
        Optional<Plat> searchedPlat = platRepository.findById(id);
        if (!searchedPlat.isEmpty()){
            Plat platToUpdate = searchedPlat.get();
            platToUpdate.setNom(plat.getNom());
            platToUpdate.setCalories(plat.getCalories());
            platToUpdate.setChef(plat.getChef());
            platToUpdate.setDescription(plat.getDescription());
            platToUpdate.setPrix(plat.getPrix());
            platRepository.save(platToUpdate);
        }else {
            throw new Exception(" plat inconnu");
        }
    }

    @DELETE
    @Path("/{id}")
    public void deletePlat(@NotNull @PathParam("id") long id){
        platRepository.deleteById(id);
    }
}
