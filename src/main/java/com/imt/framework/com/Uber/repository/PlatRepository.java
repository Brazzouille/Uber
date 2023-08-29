package com.imt.framework.com.Uber.repository;

import com.imt.framework.com.Uber.entities.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlatRepository extends  JpaRepository<Plat, Long>{

}
