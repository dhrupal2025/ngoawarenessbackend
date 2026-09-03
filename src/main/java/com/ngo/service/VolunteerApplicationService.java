package com.ngo.service;

import java.util.List;

import com.ngo.model.VolunteerApplication;

public interface VolunteerApplicationService {

    // =========================
    // SAVE APPLICATION
    // =========================

    VolunteerApplication saveApplication(
            VolunteerApplication application
    );


    // =========================
    // GET ALL APPLICATIONS
    // =========================

    List<VolunteerApplication> getAllApplications();


    // =========================
    // GET SINGLE APPLICATION
    // =========================

    VolunteerApplication getApplicationById(Long id);


    // =========================
    // GET APPLICATIONS BY EMAIL
    // =========================

    List<VolunteerApplication> getApplicationsByEmail(
            String email
    );


    // =========================
    // GET APPLICATIONS BY VOLUNTEER ID
    // =========================

    List<VolunteerApplication> getApplicationsByVolunteerId(
            Long volunteerId
    );


    // =========================
    // GET APPLICATIONS BY EVENT
    // =========================

    List<VolunteerApplication> getApplicationsByEvent(
            Long eventId
    );


    // =========================
    // GET APPLICATIONS BY STATUS
    // =========================

    List<VolunteerApplication> getApplicationsByStatus(
            String status
    );


    // =========================
    // CHECK DUPLICATE APPLICATION
    // =========================

    boolean hasAlreadyApplied(
            Long volunteerId,
            Long eventId
    );


    // =========================
    // UPDATE APPLICATION STATUS
    // =========================

    VolunteerApplication updateStatus(
            Long id,
            String status
    );


    // =========================
    // UPDATE VOLUNTEER HOURS
    // =========================

    VolunteerApplication updateHours(
            Long id,
            Integer hours
    );


    // =========================
    // DELETE APPLICATION
    // =========================

    void deleteApplication(Long id);
}