package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
