package com.ngo.service;

import java.util.List;

import com.ngo.model.Donation;

public interface DonationService {

    Donation saveDonation(Donation donation);

    List<Donation> getAllDonations();

    List<Donation> getDonationsByEmail(String email);

}