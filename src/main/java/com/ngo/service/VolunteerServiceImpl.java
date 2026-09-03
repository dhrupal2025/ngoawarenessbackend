package com.ngo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.model.Volunteer;
import com.ngo.repository.VolunteerRepository;

@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    private VolunteerRepository repository;

    @Override
    public Volunteer saveVolunteer(Volunteer volunteer) {

        return repository.save(volunteer);
    }

    @Override
    public List<Volunteer> getAllVolunteers() {

        return repository.findAll();
    }

    @Override
    public Volunteer getVolunteerById(Long id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteVolunteer(Long id) {

        repository.deleteById(id);
    }
}