package com.imt.framework.com.Uber.repository;

import com.imt.framework.com.Uber.entities.Allergene;
import com.imt.framework.com.Uber.entities.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AllergeneRepository extends  JpaRepository<Allergene, Long>{

}
