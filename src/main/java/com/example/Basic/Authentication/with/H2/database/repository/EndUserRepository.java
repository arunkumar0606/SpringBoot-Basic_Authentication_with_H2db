package com.example.Basic.Authentication.with.H2.database.repository;

import com.example.Basic.Authentication.with.H2.database.model.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndUserRepository extends JpaRepository<EndUser,Integer> {
    boolean existsByEmail(String email);

    EndUser findByEmail(String username);
}
