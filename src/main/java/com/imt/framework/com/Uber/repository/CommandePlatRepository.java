package com.imt.framework.com.Uber.repository;

import com.imt.framework.com.Uber.model.CommandePlat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandePlatRepository extends JpaRepository<CommandePlat, Long> {

}
