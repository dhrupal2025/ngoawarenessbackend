package com.ngo.service;

import java.util.List;

import com.ngo.model.Volunteer;

public interface VolunteerService {

    Volunteer saveVolunteer(Volunteer volunteer);

    List<Volunteer> getAllVolunteers();

    Volunteer getVolunteerById(Long id);

    void deleteVolunteer(Long id);
}