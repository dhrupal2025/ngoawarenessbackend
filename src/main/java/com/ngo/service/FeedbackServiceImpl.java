package com.ngo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.model.Feedback;
import com.ngo.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    @Autowired
    private EmailService emailService;

    @Override
    public Feedback saveFeedback(Feedback feedback) {

        feedback.setFeedbackDate(LocalDateTime.now());

        Feedback saved = repository.save(feedback);

        try {
            emailService.sendFeedbackToAdmin(saved);
            emailService.sendThankYouMail(saved);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return saved;
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return repository.findAll();
    }

    @Override
    public Feedback getFeedbackById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteFeedback(Long id) {
        repository.deleteById(id);
    }
}