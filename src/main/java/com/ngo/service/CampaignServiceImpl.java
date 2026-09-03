package com.ngo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.model.Campaign;
import com.ngo.repository.CampaignRepository;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignRepository repository;

    // =========================
    // SAVE CAMPAIGN
    // =========================

    @Override
    public Campaign saveCampaign(Campaign campaign) {

        // New campaign starts with 0 collected amount
        if (campaign.getCollectedAmount() == null) {
            campaign.setCollectedAmount(0.0);
        }

        // Automatically calculate status
        updateCampaignStatus(campaign);

        return repository.save(campaign);
    }

    // =========================
    // GET ALL CAMPAIGNS
    // =========================

    @Override
    public List<Campaign> getAllCampaigns() {

        List<Campaign> campaigns = repository.findAll();

        // Automatically update status
        for (Campaign campaign : campaigns) {
            updateCampaignStatus(campaign);
        }

        // Save updated statuses to database
        repository.saveAll(campaigns);

        return campaigns;
    }

    // =========================
    // GET CAMPAIGN BY ID
    // =========================

    @Override
    public Campaign getCampaignById(Long id) {

        Campaign campaign = repository.findById(id).orElse(null);

        if (campaign != null) {

            // Automatically update status
            updateCampaignStatus(campaign);

            // Save updated status
            repository.save(campaign);
        }

        return campaign;
    }

    // =========================
    // UPDATE CAMPAIGN STATUS
    // =========================

    private void updateCampaignStatus(Campaign campaign) {

        LocalDate today = LocalDate.now();

        // If dates are missing
        if (campaign.getStartDate() == null || campaign.getEndDate() == null) {
            return;
        }

        // Before start date
        if (today.isBefore(campaign.getStartDate())) {

            campaign.setStatus("Upcoming");
        }

        // After end date
        else if (today.isAfter(campaign.getEndDate())) {

            campaign.setStatus("Expired");
        }

        // Between start and end date
        else {

            campaign.setStatus("Active");
        }
    }

    // =========================
    // DELETE
    // =========================

    @Override
    public void deleteCampaign(Long id) {

        repository.deleteById(id);
    }
    @Override
    public long getCampaignCount() {
        return repository.count();
    }
}