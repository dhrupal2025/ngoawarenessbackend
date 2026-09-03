package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.model.Volunteer;

@Repository
public interface VolunteerRepository
        extends JpaRepository<Volunteer, Long> {

}