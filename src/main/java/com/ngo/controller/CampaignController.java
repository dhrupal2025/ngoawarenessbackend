package com.ngo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ngo.model.Campaign;
import com.ngo.service.CampaignService;

@RestController
@RequestMapping("/api/campaigns")
@CrossOrigin(origins = "http://localhost:5174")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;


    // =========================
    // GET ALL CAMPAIGNS
    // =========================

    @GetMapping
    public List<Campaign> getAllCampaigns() {

        return campaignService.getAllCampaigns();
    }


    // =========================
    // GET CAMPAIGN BY ID
    // =========================

    @GetMapping("/{id}")
    public Campaign getCampaignById(
            @PathVariable Long id) {

        return campaignService.getCampaignById(id);
    }

    @GetMapping("/count")
    public long getCampaignCount() {
        return campaignService.getCampaignCount();
    }
    // =========================
    // SAVE CAMPAIGN
    // =========================

    @PostMapping
    public Campaign saveCampaign(
            @RequestBody Campaign campaign) {

        return campaignService.saveCampaign(campaign);
    }


    // =========================
    // UPDATE CAMPAIGN
    // =========================

    @PutMapping("/{id}")
    public Campaign updateCampaign(
            @PathVariable Long id,
            @RequestBody Campaign campaign) {

        campaign.setId(id);

        return campaignService.saveCampaign(campaign);
    }


    // =========================
    // DELETE CAMPAIGN
    // =========================

    @DeleteMapping("/{id}")
    public void deleteCampaign(
            @PathVariable Long id) {

        campaignService.deleteCampaign(id);
    }
}