package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngo.model.Campaign;

public interface CampaignRepository
        extends JpaRepository<Campaign, Long> {
}