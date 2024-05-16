package com.example.Basic.Authentication.with.H2.database.controller;


import com.example.Basic.Authentication.with.H2.database.model.EndUser;
import com.example.Basic.Authentication.with.H2.database.service.EndUserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EndUserController {

    @Autowired
    EndUserService endUserService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/addEndUsers")
    public List<EndUser> addEndUsers(@RequestBody List<EndUser> users) {
        for(int i=0;i<users.size();i++) {
            EndUser user= users.get(i);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return endUserService.addUsersToDb(users);
    }

    @GetMapping("/endUserData")
    public String data() {
        return new JSONObject().put("release-date", "1/1/2025")
                .put("signature", "arun")
                .put("salary", "150K").toString();
    }


}
