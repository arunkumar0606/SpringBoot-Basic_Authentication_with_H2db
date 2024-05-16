package com.example.Basic.Authentication.with.H2.database.service;

import com.example.Basic.Authentication.with.H2.database.model.EndUser;
import com.example.Basic.Authentication.with.H2.database.repository.EndUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    EndUserRepository endUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(endUserRepository.existsByEmail(username)){
            EndUser user=endUserRepository.findByEmail(username);
            return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
        }else{
            System.out.println("NOt found!");
            return null;
        }

    }
}
