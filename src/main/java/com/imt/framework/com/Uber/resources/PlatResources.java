package com.imt.framework.com.Uber.resources;

import com.imt.framework.com.Uber.entities.Plat;
import com.imt.framework.com.Uber.repository.PlatRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
}
