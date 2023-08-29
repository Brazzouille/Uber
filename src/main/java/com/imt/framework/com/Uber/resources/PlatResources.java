package com.imt.framework.com.Uber.resources;

import com.imt.framework.com.Uber.entities.Plat;
import com.imt.framework.com.Uber.repository.PlatRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("plat")
public class PlatResources {
    @Autowired
    private PlatRepository platRepository;

    @GET
    @Produces( value = "application/json")
    public List<Plat> getPlat(){
        return platRepository.findAll();
    }
}
