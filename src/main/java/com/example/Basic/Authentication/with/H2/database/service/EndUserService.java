package com.example.Basic.Authentication.with.H2.database.service;


import com.example.Basic.Authentication.with.H2.database.model.EndUser;
import com.example.Basic.Authentication.with.H2.database.repository.EndUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndUserService {

    @Autowired
    EndUserRepository userRepository;

    public List<EndUser> addUsersToDb(List<EndUser> users) {
        userRepository.saveAll(users);
        return userRepository.findAll();
    }
}
