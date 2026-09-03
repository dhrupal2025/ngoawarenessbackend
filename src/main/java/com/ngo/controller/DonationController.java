package com.ngo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ngo.model.Donation;
import com.ngo.service.DonationService;

@RestController
@RequestMapping("/api/donations")
@CrossOrigin(origins = "http://localhost:5174")
public class DonationController {

    @Autowired
    private DonationService donationService;


    // =========================
    // SAVE DONATION
    // =========================

    @PostMapping
    public Donation saveDonation(
            @RequestBody Donation donation) {

        return donationService.saveDonation(donation);
    }


    // =========================
    // ALL DONATIONS
    // =========================

    @GetMapping
    public List<Donation> getAllDonations() {

        return donationService.getAllDonations();
    }


    // =========================
    // MY DONATIONS
    // =========================

    @GetMapping("/my")
    public List<Donation> getMyDonations(
            @RequestParam String email) {

        return donationService.getDonationsByEmail(email);
    }

}