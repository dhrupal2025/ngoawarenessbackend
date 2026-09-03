package com.ngo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.model.VolunteerApplication;
import com.ngo.repository.VolunteerApplicationRepository;

@Service
public class VolunteerApplicationServiceImpl
        implements VolunteerApplicationService {

    @Autowired
    private VolunteerApplicationRepository repository;


    // =========================
    // SAVE APPLICATION
    // =========================

    @Override
    public VolunteerApplication saveApplication(
            VolunteerApplication application) {

        // Prevent duplicate application
        if (application.getVolunteerId() != null
                && application.getEventId() != null) {

            boolean alreadyApplied =
                    repository.existsByVolunteerIdAndEventId(
                            application.getVolunteerId(),
                            application.getEventId()
                    );

            if (alreadyApplied) {

                throw new IllegalArgumentException(
                        "You have already applied for this event."
                );
            }
        }


        // Set application date automatically
        if (application.getApplicationDate() == null) {

            application.setApplicationDate(
                    LocalDate.now()
            );
        }


        // Default status
        if (application.getStatus() == null
                || application.getStatus().trim().isEmpty()) {

            application.setStatus("Pending");
        }


        // Default hours
        if (application.getHours() == null) {

            application.setHours(0);
        }


        return repository.save(application);
    }


    // =========================
    // GET ALL APPLICATIONS
    // =========================

    @Override
    public List<VolunteerApplication> getAllApplications() {

        return repository.findAll();
    }


    // =========================
    // GET APPLICATION BY ID
    // =========================

    @Override
    public VolunteerApplication getApplicationById(
            Long id) {

        return repository.findById(id).orElse(null);
    }


    // =========================
    // GET APPLICATIONS BY EMAIL
    // =========================

    @Override
    public List<VolunteerApplication> getApplicationsByEmail(
            String email) {

        return repository.findByEmailIgnoreCase(email);
    }


    // =========================
    // GET APPLICATIONS BY
    // VOLUNTEER ID
    // =========================

    @Override
    public List<VolunteerApplication> getApplicationsByVolunteerId(
            Long volunteerId) {

        return repository.findByVolunteerId(volunteerId);
    }


    // =========================
    // GET APPLICATIONS BY EVENT
    // =========================

    @Override
    public List<VolunteerApplication> getApplicationsByEvent(
            Long eventId) {

        return repository.findByEventId(eventId);
    }


    // =========================
    // GET APPLICATIONS BY STATUS
    // =========================

    @Override
    public List<VolunteerApplication> getApplicationsByStatus(
            String status) {

        return repository.findByStatusIgnoreCase(status);
    }


    // =========================
    // CHECK DUPLICATE APPLICATION
    // =========================

    @Override
    public boolean hasAlreadyApplied(
            Long volunteerId,
            Long eventId) {

        return repository.existsByVolunteerIdAndEventId(
                volunteerId,
                eventId
        );
    }


    // =========================
    // UPDATE STATUS
    // =========================

    @Override
    public VolunteerApplication updateStatus(
            Long id,
            String status) {

        VolunteerApplication application =
                repository.findById(id).orElse(null);


        if (application == null) {

            return null;
        }


        if (status == null
                || status.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Status cannot be empty"
            );
        }


        if (!status.equalsIgnoreCase("Pending")
                && !status.equalsIgnoreCase("Accepted")
                && !status.equalsIgnoreCase("Rejected")
                && !status.equalsIgnoreCase("Completed")) {

            throw new IllegalArgumentException(
                    "Invalid application status"
            );
        }


        // Store standard status format
        if (status.equalsIgnoreCase("Pending")) {
            application.setStatus("Pending");

        } else if (status.equalsIgnoreCase("Accepted")) {
            application.setStatus("Accepted");

        } else if (status.equalsIgnoreCase("Rejected")) {
            application.setStatus("Rejected");

        } else if (status.equalsIgnoreCase("Completed")) {
            application.setStatus("Completed");
        }
        return repository.save(application);
    }


    // =========================
    // UPDATE VOLUNTEER HOURS
    // =========================

    @Override
    public VolunteerApplication updateHours(
            Long id,
            Integer hours) {

        VolunteerApplication application =
                repository.findById(id).orElse(null);


        if (application == null) {

            return null;
        }


        if (hours == null || hours < 0) {

            throw new IllegalArgumentException(
                    "Hours must be 0 or greater"
            );
        }


        application.setHours(hours);


        return repository.save(application);
    }


    // =========================
    // DELETE APPLICATION
    // =========================

    @Override
    public void deleteApplication(Long id) {

        repository.deleteById(id);
    }
}