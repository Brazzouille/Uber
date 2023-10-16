package com.imt.framework.com.Uber.repository;

import com.imt.framework.com.Uber.model.CommandePlat;
import com.imt.framework.com.Uber.model.CommandePlatId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandePlatRepository extends JpaRepository<CommandePlat, Long> {

}
