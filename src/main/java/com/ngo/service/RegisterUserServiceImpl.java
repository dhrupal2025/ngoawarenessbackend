package com.ngo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.model.RegisterUser;
import com.ngo.repository.RegisterUserRepository;

@Service
public class RegisterUserServiceImpl
        implements RegisterUserService {

    @Autowired
    private RegisterUserRepository registerUserRepository;


    // =========================================
    // SAVE USER
    // =========================================

    @Override
    public RegisterUser saveUser(RegisterUser user) {

        String email = user.getEmail()
                .trim()
                .toLowerCase();

        // Check duplicate email
        if (registerUserRepository.existsByEmail(email)) {
            throw new RuntimeException(
                    "This email is already registered."
            );
        }

        user.setEmail(email);

        return registerUserRepository.save(user);
    }


    // =========================================
    // CHECK EMAIL EXISTS
    // =========================================

    @Override
    public boolean emailExists(String email) {

        if (email == null ||
            email.trim().isEmpty()) {

            return false;
        }

        return registerUserRepository.existsByEmail(
                email.trim().toLowerCase()
        );
    }


    // =========================================
    // GET ALL USERS
    // =========================================

    @Override
    public List<RegisterUser> getAllUsers() {

        return registerUserRepository.findAll();
    }


    // =========================================
    // GET USER BY ID
    // =========================================

    @Override
    public RegisterUser getUserById(Long id) {

        return registerUserRepository
                .findById(id)
                .orElse(null);
    }


    // =========================================
    // UPDATE USER
    // =========================================

    @Override
    public RegisterUser updateUser(
            Long id,
            RegisterUser user) {

        RegisterUser existingUser =
                registerUserRepository
                        .findById(id)
                        .orElse(null);


        if (existingUser != null) {

            existingUser.setName(
                    user.getName()
            );

            existingUser.setEmail(
                    user.getEmail()
                            .trim()
                            .toLowerCase()
            );

            existingUser.setMobile(
                    user.getMobile()
            );

            existingUser.setPassword(
                    user.getPassword()
            );

            return registerUserRepository.save(
                    existingUser
            );
        }


        return null;
    }


    // =========================================
    // DELETE USER
    // =========================================

    @Override
    public void deleteUser(Long id) {

        registerUserRepository.deleteById(id);
    }


    // =========================================
    // LOGIN
    // =========================================

    @Override
    public RegisterUser loginUser(
            String email,
            String password) {

        if (email == null ||
            password == null) {

            return null;
        }


        email = email
                .trim()
                .toLowerCase();


        return registerUserRepository
                .findByEmailAndPassword(
                        email,
                        password
                );
    }
}