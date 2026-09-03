package com.ngo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.model.Campaign;
import com.ngo.model.Donation;
import com.ngo.repository.CampaignRepository;
import com.ngo.repository.DonationRepository;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    // =========================
    // SAVE DONATION
    // =========================

    @Override
    public Donation saveDonation(Donation donation) {

        // Check campaign ID
        if (donation.getCampaignId() == null) {

            throw new RuntimeException(
                    "Campaign ID is required"
            );
        }

        // Check donor name
        if (donation.getDonorName() == null ||
                donation.getDonorName().trim().isEmpty()) {

            throw new RuntimeException(
                    "Donor name is required"
            );
        }

        // Check email
        if (donation.getEmail() == null ||
                donation.getEmail().trim().isEmpty()) {

            throw new RuntimeException(
                    "Email is required"
            );
        }

        // Check mobile
        if (donation.getMobile() == null ||
                donation.getMobile().trim().isEmpty()) {

            throw new RuntimeException(
                    "Mobile number is required"
            );
        }

        // Check amount
        if (donation.getAmount() == null ||
                donation.getAmount() <= 0) {

            throw new RuntimeException(
                    "Donation amount must be greater than 0"
            );
        }

        // =========================
        // CLEAN DATA
        // =========================

        donation.setDonorName(
                donation.getDonorName().trim()
        );

        donation.setEmail(
                donation.getEmail().trim()
        );

        donation.setMobile(
                donation.getMobile().trim()
        );

        // =========================
        // FIND CAMPAIGN
        // =========================

        Campaign campaign =
                campaignRepository
                        .findById(donation.getCampaignId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Campaign not found"
                                )
                        );

        // =========================
        // DONATION DATE
        // =========================

        donation.setDonationDate(
                LocalDate.now()
        );

        // =========================
        // CAMPAIGN INFORMATION
        // =========================

        donation.setCampaignId(
                campaign.getId()
        );

        donation.setCampaignTitle(
                campaign.getTitle()
        );

        // =========================
        // UPDATE CAMPAIGN AMOUNT
        // =========================

        Double currentAmount =
                campaign.getCollectedAmount() == null
                        ? 0.0
                        : campaign.getCollectedAmount();

        campaign.setCollectedAmount(
                currentAmount + donation.getAmount()
        );

        // Save campaign only once
        campaignRepository.save(campaign);

        // =========================
        // SAVE DONATION
        // =========================

        Donation savedDonation =
                donationRepository.save(donation);

        return savedDonation;
    }

    // =========================
    // GET ALL DONATIONS
    // =========================

    @Override
    public List<Donation> getAllDonations() {

        return donationRepository.findAll();
    }

    // =========================
    // GET MY DONATIONS
    // =========================

    @Override
    public List<Donation> getDonationsByEmail(
            String email) {

        if (email == null ||
                email.trim().isEmpty()) {

            return List.of();
        }

        return donationRepository.findByEmail(
                email.trim()
        );
    }
}