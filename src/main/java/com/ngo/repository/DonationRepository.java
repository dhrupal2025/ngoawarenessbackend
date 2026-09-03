package com.ngo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngo.model.Donation;

public interface DonationRepository
        extends JpaRepository<Donation, Long> {

    List<Donation> findByEmail(String email);

}