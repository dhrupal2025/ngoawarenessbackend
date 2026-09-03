package com.ngo.service;

import java.util.List;

import com.ngo.model.RegisterUser;

public interface RegisterUserService {

    RegisterUser saveUser(RegisterUser user);

    List<RegisterUser> getAllUsers();

    RegisterUser getUserById(Long id);

    RegisterUser updateUser(
            Long id,
            RegisterUser user
    );

    void deleteUser(Long id);

    RegisterUser loginUser(
            String email,
            String password
    );

    boolean emailExists(String email);
}