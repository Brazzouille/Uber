package com.imt.framework.com.Uber.repository;

import com.imt.framework.com.Uber.model.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PlatRepository extends JpaRepository<Plat, Long>{
    @Query("Select p from Plat p where p.prix < :maxPrix")
    List<Plat> getPlatWithMaxPriceFilter(@Param("maxPrix") double maxPrix);

    @Query("Select p from Plat p where p.prix < :maxPrix")
    List<Plat> getPlatWithOrigineFilter(@Param("maxPrix") double maxPrix);

}
