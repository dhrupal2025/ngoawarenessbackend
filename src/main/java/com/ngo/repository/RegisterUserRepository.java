package com.ngo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.model.RegisterUser;

@Repository
public interface RegisterUserRepository
        extends JpaRepository<RegisterUser, Long> {

    // Find user by email
    Optional<RegisterUser> findByEmail(String email);

    // Check duplicate email during registration
    boolean existsByEmail(String email);

    // Login
    RegisterUser findByEmailAndPassword(
            String email,
            String password
    );
}