package com.imt.framework.com.Uber.service;

import com.imt.framework.com.Uber.model.CommandePlat;
import com.imt.framework.com.Uber.repository.CommandePlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandePlatService {
    @Autowired
    private CommandePlatRepository commandePlatRepository;

}
