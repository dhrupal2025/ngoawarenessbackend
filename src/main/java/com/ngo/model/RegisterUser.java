package com.ngo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registeruser")
public class RegisterUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String mobile;

    private String password;


    // Default Constructor
    public RegisterUser() {
    }


    // Parameterized Constructor
    public RegisterUser(
            Long id,
            String name,
            String email,
            String mobile,
            String password) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }


    // =========================
    // GETTERS AND SETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // =========================
    // TO STRING
    // =========================

    @Override
    public String toString() {

        return "RegisterUser [id=" + id
                + ", name=" + name
                + ", email=" + email
                + ", mobile=" + mobile
                + "]";
    }
}