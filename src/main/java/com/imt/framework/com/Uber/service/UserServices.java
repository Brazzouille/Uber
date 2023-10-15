package com.imt.framework.com.Uber.service;

import com.imt.framework.com.Uber.model.User;
import com.imt.framework.com.Uber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }


}
