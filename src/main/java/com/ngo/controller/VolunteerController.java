package com.ngo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ngo.model.Volunteer;
import com.ngo.service.VolunteerService;

@RestController
@RequestMapping("/api/volunteers")
@CrossOrigin(origins = "http://localhost:5174")
public class VolunteerController {

    @Autowired
    private VolunteerService service;


    // ADD VOLUNTEER OPPORTUNITY
    @PostMapping
    public Volunteer saveVolunteer(
            @RequestBody Volunteer volunteer) {

        return service.saveVolunteer(volunteer);
    }


    // GET ALL
    @GetMapping
    public List<Volunteer> getAllVolunteers() {

        return service.getAllVolunteers();
    }


    // GET BY ID
    @GetMapping("/{id}")
    public Volunteer getVolunteerById(
            @PathVariable Long id) {

        return service.getVolunteerById(id);
    }


    // UPDATE
    @PutMapping("/{id}")
    public Volunteer updateVolunteer(
            @PathVariable Long id,
            @RequestBody Volunteer volunteer) {

        volunteer.setId(id);

        return service.saveVolunteer(volunteer);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public void deleteVolunteer(
            @PathVariable Long id) {

        service.deleteVolunteer(id);
    }
}