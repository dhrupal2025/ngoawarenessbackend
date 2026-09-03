package com.ngo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ngo.model.VolunteerApplication;
import com.ngo.service.VolunteerApplicationService;

@RestController
@RequestMapping("/api/volunteer-applications")
@CrossOrigin(origins = "http://localhost:5174")
public class VolunteerApplicationController {

    @Autowired
    private VolunteerApplicationService service;


    // =========================
    // APPLY FOR EVENT
    // =========================

    @PostMapping("/{eventId}")
    public VolunteerApplication applyVolunteer(
            @PathVariable Long eventId,
            @RequestBody VolunteerApplication application) {

        application.setId(null);

        application.setEventId(eventId);

        // Every new application starts as Pending
        application.setStatus("Pending");

        return service.saveApplication(application);
    }


    // =========================
    // GET ALL APPLICATIONS
    // ADMIN
    // =========================

    @GetMapping
    public List<VolunteerApplication> getAll() {

        return service.getAllApplications();
    }


    // =========================
    // GET APPLICATION BY ID
    // =========================

    @GetMapping("/{id}")
    public VolunteerApplication getById(
            @PathVariable Long id) {

        return service.getApplicationById(id);
    }


    // =========================
    // GET MY APPLICATIONS
    // CUSTOMER
    // =========================

    @GetMapping("/my")
    public List<VolunteerApplication> getMyApplications(
            @RequestParam String email) {

        return service.getApplicationsByEmail(email);
    }


    // =========================
    // GET BY EVENT
    // =========================

    @GetMapping("/event/{eventId}")
    public List<VolunteerApplication> getByEvent(
            @PathVariable Long eventId) {

        return service.getApplicationsByEvent(eventId);
    }


    // =========================
    // UPDATE STATUS
    // ADMIN
    // =========================

    @PutMapping("/{id}/status")
    public VolunteerApplication updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return service.updateStatus(id, status);
    }


    // =========================
    // DELETE
    // =========================

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        service.deleteApplication(id);
    }
}