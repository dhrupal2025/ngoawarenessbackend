package com.ngo.service;

import java.util.List;

import com.ngo.model.Campaign;

public interface CampaignService {

    Campaign saveCampaign(Campaign campaign);

    List<Campaign> getAllCampaigns();

    void deleteCampaign(Long id);

	Campaign getCampaignById(Long id);

	long getCampaignCount();
}