package com.ngo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.model.VolunteerApplication;

@Repository
public interface VolunteerApplicationRepository
        extends JpaRepository<VolunteerApplication, Long> {


    // =========================
    // GET APPLICATIONS BY EMAIL
    // =========================

    List<VolunteerApplication> findByEmailIgnoreCase(String email);


    // =========================
    // GET APPLICATIONS BY
    // VOLUNTEER ID
    // =========================

    List<VolunteerApplication> findByVolunteerId(Long volunteerId);


    // =========================
    // GET APPLICATIONS BY EVENT
    // =========================

    List<VolunteerApplication> findByEventId(Long eventId);


    // =========================
    // GET APPLICATIONS BY STATUS
    // =========================

    List<VolunteerApplication> findByStatusIgnoreCase(String status);


    // =========================
    // CHECK DUPLICATE APPLICATION
    // =========================

    boolean existsByVolunteerIdAndEventId(
            Long volunteerId,
            Long eventId
    );
}