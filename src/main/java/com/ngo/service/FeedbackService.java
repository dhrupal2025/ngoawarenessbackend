package com.ngo.service;

import java.util.List;

import com.ngo.model.Feedback;

public interface FeedbackService {

    Feedback saveFeedback(Feedback feedback);

    List<Feedback> getAllFeedback();

    Feedback getFeedbackById(Long id);

    void deleteFeedback(Long id);

}